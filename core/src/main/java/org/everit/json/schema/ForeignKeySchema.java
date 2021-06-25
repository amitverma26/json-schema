package org.everit.json.schema;

import java.util.Objects;

import org.everit.json.schema.StringSchema.Builder;

/**
 * Extension of the JSON Schema to address FK
 * @author averm
 * Foreign Key Schema 
 * { 
 * "type":"ForeignKey",
 * "entity":"[table name]"
 * "label":"[fields in the referred table]",
 * "hardConstraint":[Boolean],
 * "required":"[Boolean]",
 * "filter":"SQL expression for filtering",
 * "title":"String",
 * "description":"String"
 * 
 * }
 * 
 */
public class ForeignKeySchema extends Schema {
	
	/**
	 * Builder class for {@link ForeignKeySchema}
	 */
	
	public static class Builder extends Schema.Builder<ForeignKeySchema> {
		
		private String entity;
		private String label;
		private Boolean hardConstraint = true;
		private Boolean required = false;
		private String filter;
		private String title;
		private String description;
		
		public Builder entity(final String entity) {
			this.entity = entity;
			return this;
		}
		
		public Builder label(final String label) {
			this.label = label;
			return this;
		}
		
		public Builder hardConstraint(final Boolean hardConstraint) {
			this.hardConstraint = hardConstraint;
			return this;
		}
		
		private Builder required(final Boolean required) {
			this.required = required;
			return this;
		}
		
		private Builder filter(final String filter) {
			this.filter = filter;
			return this;
		}
		
		@Override 
		public ForeignKeySchema build() {
			return new ForeignKeySchema(this);
		}
		
	}

	public static Builder builder() {
        return new Builder();
    }
	
	private String entity;
	private String label;
	private Boolean hardConstraint = true;
	private Boolean required = false;
	private String filter;
	private String title;
	private String description;
	
	public ForeignKeySchema() {
        this(builder());
    }
	
	public ForeignKeySchema(final Builder builder){
        super(builder);
        this.entity = builder.entity;
        this.filter = builder.filter;
        this.hardConstraint = builder.hardConstraint;
        this.label = builder.label;
        this.required = builder.required;
        
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
    
        if(o instanceof ForeignKeySchema) {
        	ForeignKeySchema that = (ForeignKeySchema) o;
        	return that.canEqual(this) &&
        			entity == that.entity &&
        			filter == that.filter &&
        			hardConstraint == that.hardConstraint &&
        			label == that.label &&
        			required == that.required &&
        			super.equals(that);
        			
        } else {
            return false;
        }
	}
	
	 @Override
	    protected boolean canEqual(Object other) {
	        return other instanceof ForeignKeySchema;
	 }
	 
	 @Override
	    public int hashCode() {
	        return Objects.hash(super.hashCode(),entity,filter,hardConstraint,label,required);
	        		
	 }
	 
	@Override
	void accept(Visitor visitor) {
		// TODO Create the visitor Foreign Key

		visitor.visitForeignKeySchema(this);
	}
	
	public String getEntity() {
		return entity;
	}

}
