/**
 */
package aspectj.impl;

import aspectj.AspectjPackage;
import aspectj.PointCut;
import aspectj.PointCutConjunction;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Cut Conjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link aspectj.impl.PointCutConjunctionImpl#getComposee <em>Composee</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointCutConjunctionImpl extends PointCutImpl implements PointCutConjunction {
	/**
	 * The cached value of the '{@link #getComposee() <em>Composee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposee()
	 * @generated
	 * @ordered
	 */
	protected EList<PointCut> composee;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointCutConjunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AspectjPackage.Literals.POINT_CUT_CONJUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PointCut> getComposee() {
		if (composee == null) {
			composee = new EObjectResolvingEList<PointCut>(PointCut.class, this, AspectjPackage.POINT_CUT_CONJUNCTION__COMPOSEE);
		}
		return composee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_CONJUNCTION__COMPOSEE:
				return getComposee();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_CONJUNCTION__COMPOSEE:
				getComposee().clear();
				getComposee().addAll((Collection<? extends PointCut>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_CONJUNCTION__COMPOSEE:
				getComposee().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_CONJUNCTION__COMPOSEE:
				return composee != null && !composee.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PointCutConjunctionImpl
