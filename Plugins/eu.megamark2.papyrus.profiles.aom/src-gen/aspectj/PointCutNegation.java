/**
 */
package aspectj;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point Cut Negation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link aspectj.PointCutNegation#getComposee <em>Composee</em>}</li>
 * </ul>
 *
 * @see aspectj.AspectjPackage#getPointCutNegation()
 * @model
 * @generated
 */
public interface PointCutNegation extends PointCut {
	/**
	 * Returns the value of the '<em><b>Composee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composee</em>' reference.
	 * @see #setComposee(PointCut)
	 * @see aspectj.AspectjPackage#getPointCutNegation_Composee()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PointCut getComposee();

	/**
	 * Sets the value of the '{@link aspectj.PointCutNegation#getComposee <em>Composee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composee</em>' reference.
	 * @see #getComposee()
	 * @generated
	 */
	void setComposee(PointCut value);

} // PointCutNegation
