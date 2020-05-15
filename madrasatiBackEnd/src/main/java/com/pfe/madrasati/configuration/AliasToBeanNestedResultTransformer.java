package com.pfe.madrasati.configuration;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.property.access.internal.PropertyAccessStrategyFieldImpl;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.Setter;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.springframework.util.Assert;

/**
 * Help to transform aliases with nested aliases.
 * @author SDEROUICHE
 * @author HBENNCIR
 * @author BBARHOUMI
 */
public class AliasToBeanNestedResultTransformer extends AliasedTupleSubsetResultTransformer {

  private static final long serialVersionUID = -8047276133980128266L;

  private static final int TUPE_INDEX = 0;
  private static final int ALISES_INDEX = 1;
  private static final int FIELDNAME_INDEX = 2;

//  private static final PropertyAccessor accessor = PropertyAccessorFactory.getPropertyAccessor("property");
  PropertyAccessStrategy accessor = PropertyAccessStrategyFieldImpl.INSTANCE;
//  PropertyAccess access = accessor.buildPropertyAccess(entityClass, "property");
  private final Class<?> resultClass;

  private Object[] entityTuples;
  private String[] entityAliases;

  private Map<String, Class<?>> fieldToClass = new HashMap<String, Class<?>>();
  private Map<String, List<?>> subEntities = new HashMap<String, List<?>>();
  private List<String> nestedAliases = new ArrayList<String>();
  private Map<String, Class<?>> listFields = new HashMap<String, Class<?>>();

  public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
    return false;
  }

  public AliasToBeanNestedResultTransformer(final Class<?> resultClass) {
    Assert.notNull(resultClass, "[Assertion failed] - 'resultClass' is required; it must not be null");
    this.resultClass = resultClass;
  }

  public Object transformTuple(Object[] tuple, String[] aliases) {
    Assert.notNull(tuple, "[Assertion failed] - 'tuple' is required; it must not be null");
    Assert.notNull(aliases, "[Assertion failed] - 'aliases' is required; it must not be null");
    Assert.noNullElements(aliases, "[Assertion failed] - 'aliases' array must not contain any null elements");
    handleSubEntities(tuple, aliases);
    cleanParams(tuple, aliases);
    final ResultTransformer rootTransformer = new AliasToBeanResultTransformer(this.resultClass);
    final Object[] finalTuple = castToSetterType();
    final Object[] myTuple;
    if (finalTuple == null) {
      myTuple = this.entityTuples;
    } else {
      myTuple = finalTuple;
    }
    final Object root = rootTransformer.transformTuple(myTuple, getEntityAliases());
//    loadSubEntities(root);

    cleanMaps();
    return root;
  }

  void handleSubEntities(Object[] tuple, String[] aliases) throws HibernateException {
    Assert.notNull(tuple, "[Assertion failed] - 'tuple' is required; it must not be null");
    Assert.notNull(aliases, "[Assertion failed] - 'aliases' is required; it must not be null");
    Assert.noNullElements(aliases, "[Assertion failed] - 'aliases' array must not contain any null elements");
    String fieldName = "";
    String aliasName = "";
    try {
      for (int i = 0; i < aliases.length; i++) {
        String alias = aliases[i];
        if (alias.contains(".")) {

          String[] sp = alias.split("\\.");
          StringBuilder aliasBuilder = new StringBuilder();
          for (int j = 0; j < sp.length; j++) {
            if (j == 0) {
              fieldName = sp[j];
            } else {
              aliasBuilder.append(sp[j]);
              aliasBuilder.append(".");
            }
          }
          aliasName = aliasBuilder.substring(0, aliasBuilder.length() - 1);

          nestedAliases.add(alias);
          manageEntities(fieldName, aliasName, tuple[i]);
        }
      }
    } catch (NoSuchFieldException e) {
      throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName() + " for field name: " + fieldName + " and alias name:" + aliasName);
    }
  }

  Class<?> findClass(final String fieldName) throws NoSuchFieldException, SecurityException {
    Assert.hasText(fieldName, "[Assertion failed] - 'fieldName' must have text; it must not be null, empty, or blank");
    if (fieldToClass.containsKey(fieldName)) {
      return fieldToClass.get(fieldName);
    } else {
      Class<?> subclass = resultClass.getDeclaredField(fieldName).getType();

      if (subclass.equals(List.class) || subclass.equals(Set.class)) {
        if (subclass.equals(List.class)) {
          listFields.put(fieldName, LinkedList.class);
        } else {
          listFields.put(fieldName, HashSet.class);
        }
        Field field = resultClass.getDeclaredField(fieldName);
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        subclass = (Class<?>) genericType.getActualTypeArguments()[0];

      }
      fieldToClass.put(fieldName, subclass);
      return subclass;
    }
  }

  @SuppressWarnings("unchecked")
  void manageEntities(final String fieldName, final String aliasName, final Object tupleValue) throws NoSuchFieldException, SecurityException {
    Assert.hasText(fieldName, "[Assertion failed] - 'fieldName' must have text; it must not be null, empty, or blank");
    Assert.hasText(aliasName, "[Assertion failed] - 'aliasName' must have text; it must not be null, empty, or blank");
//    Assert.notNull(tupleValue, "[Assertion failed] - 'tupleValue' is required; it must not be null");
    Class<?> subclass = findClass(fieldName);
    if (!subEntities.containsKey(fieldName)) {
      List<Object> list = new ArrayList<Object>();
      list.add(new ArrayList<Object>());
      list.add(new ArrayList<String>());
      list.add(FIELDNAME_INDEX, subclass);
      subEntities.put(fieldName, list);
    }
    ((List<Object>) subEntities.get(fieldName).get(TUPE_INDEX)).add(tupleValue);
    ((List<String>) subEntities.get(fieldName).get(ALISES_INDEX)).add(aliasName);
  }

  void cleanParams(Object[] tuple, String[] aliases) {
    Assert.notNull(tuple, "[Assertion failed] - 'tuple' is required; it must not be null");
    Assert.notNull(aliases, "[Assertion failed] - 'aliases' is required; it must not be null");
    Assert.noNullElements(aliases, "[Assertion failed] - 'aliases' array must not contain any null elements");
    entityTuples = new Object[aliases.length - nestedAliases.size()];
    this.entityAliases = new String[aliases.length - nestedAliases.size()];

    for (int j = 0, i = 0; j < aliases.length; j++) {
      if (!nestedAliases.contains(aliases[j])) {
        entityTuples[i] = tuple[j];
        getEntityAliases()[i] = aliases[j];
        ++i;
      }
    }
  }

//    @SuppressWarnings({ "unchecked" })
//    void loadSubEntities(Object root) throws HibernateException {
//        Assert.notNull(root, "[Assertion failed] - 'root' is required; it must not be null");
//        try {
//            for (Entry<String, List<?>> entry : subEntities.entrySet()) {
//                final String fieldName = entry.getKey();
//                final List<?> list = entry.getValue();
//                final Class<?> subclass = (Class<?>) list.get(FIELDNAME_INDEX);
//
//                final ResultTransformer subclassTransformer = new AliasToBeanNestedResultTransformer(subclass);
//
//                final Object[] aliases = ((List<Object>) list.get(0)).toArray();
//                final String[] tuple = ((List<Object>) list.get(1)).toArray(new String[0]);
//                final Object subObject = subclassTransformer.transformTuple(aliases, tuple);
//
//                invokeSetters(root, fieldName, subObject);
//            }
//        } catch (InstantiationException | IllegalAccessException e) {
//            throw new HibernateException(e);
//        } catch (Exception e) {
//            throw new HibernateException(e);
//        }
//    }

  /**
   * @param root
   * @param fieldName
   * @param subObject
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
//  @SuppressWarnings({ "rawtypes", "unchecked" })
//  void invokeSetters(Object root, String fieldName, final Object subObject) throws InstantiationException, IllegalAccessException {
//    Assert.notNull(root, "[Assertion failed] - 'root' is required; it must not be null");
//    Assert.hasText(fieldName, "[Assertion failed] - 'fieldName' must have text; it must not be null, empty, or blank");
//    Assert.notNull(subObject, "[Assertion failed] - 'subObject' is required; it must not be null");
//
//    final Setter setter = access.getSetter(resultClass, fieldName);
//    if (listFields.containsKey(fieldName)) {
//      final Class<?> collectionClass = listFields.get(fieldName);
//      final Collection subObjectList = (Collection) collectionClass.newInstance();
//      subObjectList.add(subObject);
//      setter.set(root, subObjectList, null);
//    } else {
//      setter.set(root, subObject, null);
//    }
//  }

  void cleanMaps() {
    this.fieldToClass = new HashMap<String, Class<?>>();
    this.subEntities = new HashMap<String, List<?>>();
    this.nestedAliases = new ArrayList<String>();
    this.listFields = new HashMap<String, Class<?>>();
  }

  Object[] castToSetterType() {
    return null;
  }

  String[] getEntityAliases() {
    return this.entityAliases;
  }

  Class<?> getResultClass() {
    return this.resultClass;
  }

  Object[] getEntityTuples() {
    return this.entityTuples;
  }

}
