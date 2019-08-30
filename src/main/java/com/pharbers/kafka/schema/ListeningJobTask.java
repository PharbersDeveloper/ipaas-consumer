/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.pharbers.kafka.schema;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ListeningJobTask extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1227051739213368068L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ListeningJobTask\",\"namespace\":\"com.pharbers.kafka.schema\",\"fields\":[{\"name\":\"JobId\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence JobId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ListeningJobTask() {}

  /**
   * All-args constructor.
   * @param JobId The new value for JobId
   */
  public ListeningJobTask(java.lang.CharSequence JobId) {
    this.JobId = JobId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return JobId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: JobId = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'JobId' field.
   * @return The value of the 'JobId' field.
   */
  public java.lang.CharSequence getJobId() {
    return JobId;
  }

  /**
   * Sets the value of the 'JobId' field.
   * @param value the value to set.
   */
  public void setJobId(java.lang.CharSequence value) {
    this.JobId = value;
  }

  /**
   * Creates a new ListeningJobTask RecordBuilder.
   * @return A new ListeningJobTask RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningJobTask.Builder newBuilder() {
    return new com.pharbers.kafka.schema.ListeningJobTask.Builder();
  }

  /**
   * Creates a new ListeningJobTask RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ListeningJobTask RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningJobTask.Builder newBuilder(com.pharbers.kafka.schema.ListeningJobTask.Builder other) {
    return new com.pharbers.kafka.schema.ListeningJobTask.Builder(other);
  }

  /**
   * Creates a new ListeningJobTask RecordBuilder by copying an existing ListeningJobTask instance.
   * @param other The existing instance to copy.
   * @return A new ListeningJobTask RecordBuilder
   */
  public static com.pharbers.kafka.schema.ListeningJobTask.Builder newBuilder(com.pharbers.kafka.schema.ListeningJobTask other) {
    return new com.pharbers.kafka.schema.ListeningJobTask.Builder(other);
  }

  /**
   * RecordBuilder for ListeningJobTask instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ListeningJobTask>
    implements org.apache.avro.data.RecordBuilder<ListeningJobTask> {

    private java.lang.CharSequence JobId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pharbers.kafka.schema.ListeningJobTask.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.JobId)) {
        this.JobId = data().deepCopy(fields()[0].schema(), other.JobId);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ListeningJobTask instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pharbers.kafka.schema.ListeningJobTask other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.JobId)) {
        this.JobId = data().deepCopy(fields()[0].schema(), other.JobId);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'JobId' field.
      * @return The value.
      */
    public java.lang.CharSequence getJobId() {
      return JobId;
    }

    /**
      * Sets the value of the 'JobId' field.
      * @param value The value of 'JobId'.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ListeningJobTask.Builder setJobId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.JobId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'JobId' field has been set.
      * @return True if the 'JobId' field has been set, false otherwise.
      */
    public boolean hasJobId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'JobId' field.
      * @return This builder.
      */
    public com.pharbers.kafka.schema.ListeningJobTask.Builder clearJobId() {
      JobId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public ListeningJobTask build() {
      try {
        ListeningJobTask record = new ListeningJobTask();
        record.JobId = fieldSetFlags()[0] ? this.JobId : (java.lang.CharSequence) defaultValue(fields()[0]);
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
