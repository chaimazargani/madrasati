import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

import { environment } from '../../environments/environment';

@Injectable()
export class HeaderHttpInterceptor implements HttpInterceptor {

    constructor( private router: Router ) { }

    intercept( request: HttpRequest<any>, next: HttpHandler ): Observable<HttpEvent<any>> {
        const URL_PATH = environment.contextPath;
        let url;
        const interceptedUrl = this.getIntercepted( request.url );

                url = URL_PATH + request.url;

        const customRequest = request.clone( {
            headers: request.headers,
            reportProgress: request.reportProgress,
            params: request.params,
            responseType: request.responseType,
            withCredentials: true,
            body: request.body,
            method: request.method,
            url: url
        } );

        return next.handle( customRequest ).pipe(
            catchError(( error, caught ) => {
                return throwError( error );
            } ) ) as any;
    }
    
    getIntercepted( url: string ) {
        if ( url.startsWith( 'http' ) ) {
            return 'http';
        }
        if ( url.startsWith( './assets' ) ) {
            return './assets';
        }
        return 'default';
    }

}
