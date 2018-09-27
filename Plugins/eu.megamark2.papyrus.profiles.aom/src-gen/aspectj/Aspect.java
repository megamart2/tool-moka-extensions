/**
 */
package aspectj;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link aspectj.Aspect#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link aspectj.Aspect#isPrivileged <em>Is Privileged</em>}</li>
 *   <li>{@link aspectj.Aspect#getPerType <em>Per Type</em>}</li>
 *   <li>{@link aspectj.Aspect#getPerPointCut <em>Per Point Cut</em>}</li>
 *   <li>{@link aspectj.Aspect#getDeclaredParents <em>Declared Parents</em>}</li>
 *   <li>{@link aspectj.Aspect#getDeclaredImplements <em>Declared Implements</em>}</li>
 *   <li>{@link aspectj.Aspect#getPrecedes <em>Precedes</em>}</li>
 *   <li>{@link aspectj.Aspect#getPrecededBy <em>Preceded By</em>}</li>
 * </ul>
 *
 * @see aspectj.AspectjPackage#getAspect()
 * @model
 * @generated
 */
public interface Aspect extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see aspectj.AspectjPackage#getAspect_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link aspectj.Aspect#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Is Privileged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Privileged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Privileged</em>' attribute.
	 * @see #setIsPrivileged(boolean)
	 * @see aspectj.AspectjPackage#getAspect_IsPrivileged()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isPrivileged();

	/**
	 * Sets the value of the '{@link aspectj.Aspect#isPrivileged <em>Is Privileged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Privileged</em>' attribute.
	 * @see #isPrivileged()
	 * @generated
	 */
	void setIsPrivileged(boolean value);

	/**
	 * Returns the value of the '<em><b>Per Type</b></em>' attribute list.
	 * The list contents are of type {@link aspectj.AspectInstantiationType}.
	 * The literals are from the enumeration {@link aspectj.AspectInstantiationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Per Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Per Type</em>' attribute list.
	 * @see aspectj.AspectInstantiationType
	 * @see aspectj.AspectjPackage#getAspect_PerType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AspectInstantiationType> getPerType();

	/**
	 * Returns the value of the '<em><b>Per Point Cut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Per Point Cut</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Per Point Cut</em>' reference.
	 * @see #setPerPointCut(PointCut)
	 * @see aspectj.AspectjPackage#getAspect_PerPointCut()
	 * @model ordered="false"
	 * @generated
	 */
	PointCut getPerPointCut();

	/**
	 * Sets the value of the '{@link aspectj.Aspect#getPerPointCut <em>Per Point Cut</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Per Point Cut</em>' reference.
	 * @see #getPerPointCut()
	 * @generated
	 */
	void setPerPointCut(PointCut value);

	/**
	 * Returns the value of the '<em><b>Declared Parents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Generalization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Parents</em>' reference list.
	 * @see aspectj.AspectjPackage#getAspect_DeclaredParents()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Generalization> getDeclaredParents();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Generalization} with the specified '<em><b>General</b></em>' from the '<em><b>Declared Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param general The '<em><b>General</b></em>' of the {@link org.eclipse.uml2.uml.Generalization} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Generalization} with the specified '<em><b>General</b></em>', or <code>null</code>.
	 * @see #getDeclaredParents()
	 * @generated
	 */
	Generalization getDeclaredParents(Classifier general);

	/**
	 * Returns the value of the '<em><b>Declared Implements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.InterfaceRealization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Implements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Implements</em>' reference list.
	 * @see aspectj.AspectjPackage#getAspect_DeclaredImplements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InterfaceRealization> getDeclaredImplements();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InterfaceRealization} with the specified '<em><b>Name</b></em>', and '<em><b>Contract</b></em>' from the '<em><b>Declared Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InterfaceRealization} to retrieve, or <code>null</code>.
	 * @param contract The '<em><b>Contract</b></em>' of the {@link org.eclipse.uml2.uml.InterfaceRealization} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.InterfaceRealization} with the specified '<em><b>Name</b></em>', and '<em><b>Contract</b></em>', or <code>null</code>.
	 * @see #getDeclaredImplements()
	 * @generated
	 */
	InterfaceRealization getDeclaredImplements(String name, Interface contract);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.InterfaceRealization} with the specified '<em><b>Name</b></em>', and '<em><b>Contract</b></em>' from the '<em><b>Declared Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.InterfaceRealization} to retrieve, or <code>null</code>.
	 * @param contract The '<em><b>Contract</b></em>' of the {@link org.eclipse.uml2.uml.InterfaceRealization} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.InterfaceRealization} with the specified '<em><b>Name</b></em>', and '<em><b>Contract</b></em>', or <code>null</code>.
	 * @see #getDeclaredImplements()
	 * @generated
	 */
	InterfaceRealization getDeclaredImplements(String name, Interface contract, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Precedes</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link aspectj.Aspect#getPrecededBy <em>Preceded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precedes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precedes</em>' reference.
	 * @see #setPrecedes(Aspect)
	 * @see aspectj.AspectjPackage#getAspect_Precedes()
	 * @see aspectj.Aspect#getPrecededBy
	 * @model opposite="precededBy" ordered="false"
	 * @generated
	 */
	Aspect getPrecedes();

	/**
	 * Sets the value of the '{@link aspectj.Aspect#getPrecedes <em>Precedes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precedes</em>' reference.
	 * @see #getPrecedes()
	 * @generated
	 */
	void setPrecedes(Aspect value);

	/**
	 * Returns the value of the '<em><b>Preceded By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link aspectj.Aspect#getPrecedes <em>Precedes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preceded By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preceded By</em>' reference.
	 * @see #setPrecededBy(Aspect)
	 * @see aspectj.AspectjPackage#getAspect_PrecededBy()
	 * @see aspectj.Aspect#getPrecedes
	 * @model opposite="precedes" ordered="false"
	 * @generated
	 */
	Aspect getPrecededBy();

	/**
	 * Sets the value of the '{@link aspectj.Aspect#getPrecededBy <em>Preceded By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preceded By</em>' reference.
	 * @see #getPrecededBy()
	 * @generated
	 */
	void setPrecededBy(Aspect value);

} // Aspect
