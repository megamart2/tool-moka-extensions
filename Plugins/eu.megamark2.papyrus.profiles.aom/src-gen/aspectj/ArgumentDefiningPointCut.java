/**
 */
package aspectj;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.StructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Defining Point Cut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link aspectj.ArgumentDefiningPointCut#getBase_StructuralFeature <em>Base Structural Feature</em>}</li>
 *   <li>{@link aspectj.ArgumentDefiningPointCut#getArgNames <em>Arg Names</em>}</li>
 * </ul>
 *
 * @see aspectj.AspectjPackage#getArgumentDefiningPointCut()
 * @model
 * @generated
 */
public interface ArgumentDefiningPointCut extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Structural Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Structural Feature</em>' reference.
	 * @see #setBase_StructuralFeature(StructuralFeature)
	 * @see aspectj.AspectjPackage#getArgumentDefiningPointCut_Base_StructuralFeature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	StructuralFeature getBase_StructuralFeature();

	/**
	 * Sets the value of the '{@link aspectj.ArgumentDefiningPointCut#getBase_StructuralFeature <em>Base Structural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Structural Feature</em>' reference.
	 * @see #getBase_StructuralFeature()
	 * @generated
	 */
	void setBase_StructuralFeature(StructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Arg Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arg Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg Names</em>' attribute list.
	 * @see aspectj.AspectjPackage#getArgumentDefiningPointCut_ArgNames()
	 * @model dataType="org.eclipse.uml2.types.String" required="true"
	 * @generated
	 */
	EList<String> getArgNames();

} // ArgumentDefiningPointCut
