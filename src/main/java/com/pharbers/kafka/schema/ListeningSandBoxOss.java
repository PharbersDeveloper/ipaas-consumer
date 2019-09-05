/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ListeningSandBoxOss extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4346611549058877362L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ListeningSandBoxOss\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"Path\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence Path;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ListeningSandBoxOss() {}

  /**
   * All-args constructor.
   * @param Path The new value for Path
   */
  public ListeningSandBoxOss(java.lang.CharSequence Path) {
    this.Path = Path;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return Path;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: Path = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'Path' field.
   * @return The value of the 'Path' field.
   */
  public java.lang.CharSequence getPath() {
    return Path;
  }

  /**
   * Sets the value of the 'Path' field.
   * @param value the value to set.
   */
  public void setPath(java.lang.CharSequence value) {
    this.Path = value;
  }

  /**
   * Creates a new ListeningSandBoxOss RecordBuilder.
   * @return A new ListeningSandBoxOss RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningSandBoxOss.Builder newBuilder() {
    return new com.pharbers.kafka.schema.ListeningSandBoxOss.Builder();
  }

  /**
   * Creates a new ListeningSandBoxOss RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ListeningSandBoxOss RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningSandBoxOss.Builder newBuilder(com.pharbers.kafka.schema.ListeningSandBoxOss.Builder other) {
    return new com.pharbers.kafka.schema.ListeningSandBoxOss.Builder(other);
  }

  /**
   * Creates a new ListeningSandBoxOss RecordBuilder by copying an existing ListeningSandBoxOss instance.
   * @param other The existing instance to copy.
   * @return A new ListeningSandBoxOss RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningSandBoxOss.Builder newBuilder(com.pharbers.kafka.schema.ListeningSandBoxOss other) {
    return new com.pharbers.kafka.schema.ListeningSandBoxOss.Builder(other);
  }

  /**
   * RecordBuilder for ListeningSandBoxOss instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ListeningSandBoxOss>
    implements org.apache.avro.data.RecordBuilder<ListeningSandBoxOss> {

    private java.lang.CharSequence Path;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.ListeningSandBoxOss.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.Path)) {
        this.Path = data().deepCopy(fields()[0].schema(), other.Path);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ListeningSandBoxOss instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.ListeningSandBoxOss other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.Path)) {
        this.Path = data().deepCopy(fields()[0].schema(), other.Path);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'Path' field.
      * @return The value.
      */
    public java.lang.CharSequence getPath() {
      return Path;
    }

    /**
      * Sets the value of the 'Path' field.
      * @param value The value of 'Path'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ListeningSandBoxOss.Builder setPath(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.Path = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'Path' field has been set.
      * @return True if the 'Path' field has been set, false otherwise.
      */
    public boolean hasPath() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'Path' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ListeningSandBoxOss.Builder clearPath() {
      Path = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public ListeningSandBoxOss build() {
      try {
        ListeningSandBoxOss record = new ListeningSandBoxOss();
        record.Path = fieldSetFlags()[0] ? this.Path : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}