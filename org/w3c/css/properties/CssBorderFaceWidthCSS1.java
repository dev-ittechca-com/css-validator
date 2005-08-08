//
// $Id$
// From Philippe Le Hegaret (Philippe.Le_Hegaret@sophia.inria.fr)
//
// (c) COPYRIGHT MIT and INRIA, 1997.
// Please first read the full copyright statement in file COPYRIGHT.html
/*
 * $Log$
 * Revision 1.2  2002/04/08 21:17:43  plehegar
 * New
 *
 * Revision 2.3  1997/09/09 08:43:07  plehegar
 * Added getValue()
 *
 * Revision 2.2  1997/08/20 11:41:17  plehegar
 * Freeze
 *
 * Revision 2.1  1997/08/08 15:52:08  plehegar
 * Nothing
 *
 * Revision 1.2  1997/07/30 13:19:50  plehegar
 * Updated package
 *
 * Revision 1.1  1997/07/25 12:34:40  plehegar
 * Initial revision
 *
 */
package org.w3c.css.properties;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssIdent;
import org.w3c.css.values.CssLength;
import org.w3c.css.values.CssNumber;
import org.w3c.css.values.CssValue;

/**
 * @version $Revision$
 */
public class CssBorderFaceWidthCSS1 {
    
    CssValue value;
    
    /**
     * Create a new CssBorderFaceWidthCSS1
     */
    public CssBorderFaceWidthCSS1() {
	value = medium;
    }
    
    /**
     * Create a new CssBorderFaceWidthCSS1 from an another CssBorderFaceWidthCSS1
     *
     * @param another The another side.
     */
    public CssBorderFaceWidthCSS1(CssBorderFaceWidthCSS1 another) {
	value = another.value;
    }
    
    /**
     * Create a new CssBorderFaceWidth
     *
     * @param expression The expression for this property
     * @exception InvalidParamException Values are incorrect
     */
    public CssBorderFaceWidthCSS1(ApplContext ac, CssExpression expression,
	    boolean check) throws InvalidParamException {
	
	if(check && expression.getCount() > 1) {
	    throw new InvalidParamException("unrecognize", ac);
	}
	
	CssValue val = expression.getValue();
	
	if (val instanceof CssLength) {
	    float f = ((Float) val.get()).floatValue();
	    if (f >= 0) 
		this.value = val;
	    else
		throw new InvalidParamException("negative-value", val.toString(), ac);
	} else if (val instanceof CssNumber) {
	    value = ((CssNumber) val).getLength();
	} else if (val.equals(thin)) {
	    value = thin;
	} else if (val.equals(medium)) {
	    value = medium;
	} else if (val.equals(thick)) {
	    value = thick;
	} else if (val.equals(CssProperty.inherit)) {
	    value = CssProperty.inherit;
	} else {
	    throw new InvalidParamException("value", val.toString(), "width", ac);
	}
	
	expression.next();
    }  
    
    public CssBorderFaceWidthCSS1(ApplContext ac, CssExpression expression) 
	throws InvalidParamException {
	this(ac, expression, false);
    }
    
    /**
     * Returns the internal value
     */  
    public CssValue getValue() {
	return value;
    }
    
    /**
     * Returns a string representation of the object.
     */
    public String toString() {  
	if(value != null) {
	    return value.toString();
	}
	return "";
    }
    
    /**
     * Compares two sides for equality.
     *
     * @param value The another side.
     */  
    public boolean equals(CssBorderFaceWidthCSS1 another) {
	return value.equals(another.value); // FIXME
    }
    
    private static CssIdent thin = new CssIdent("thin");
    private static CssIdent medium = new CssIdent("medium");
    private static CssIdent thick = new CssIdent("thick");
    
}



