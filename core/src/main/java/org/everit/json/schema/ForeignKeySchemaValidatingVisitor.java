package org.everit.json.schema;

import static java.util.Objects.requireNonNull;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ForeignKeySchemaValidatingVisitor extends Visitor {
	
	private final Object subject;
	
	private String foreignKeySubject;

    private final ValidatingVisitor owner;
    
    public ForeignKeySchemaValidatingVisitor(Object subject, ValidatingVisitor owner) {
        this.subject = subject;
        this.owner = requireNonNull(owner, "failureReporter cannot be null");
    }
    
    @Override void visitForeignKeySchema(ForeignKeySchema foreignKeySchema) {
    	if (owner.passesTypeCheck(String.class, true, false)) {
    		//TODO - add the logic for table lookup
    		Logger.getGlobal().log(Level.INFO, "Passed ForeignKey Check:" + foreignKeySchema.getEntity());
    	}else {
    		Logger.getGlobal().log(Level.INFO, "Passed ForeignKey Check Failed:" +  foreignKeySchema.getEntity());
    	}
    	
    	super.visitForeignKeySchema(foreignKeySchema);
    	
    }

}
