/**
 */
package aspectj.impl;

import aspectj.AspectjPackage;
import aspectj.PointCut;
import aspectj.PointCutPointCut;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Cut Point Cut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link aspectj.impl.PointCutPointCutImpl#getSelectedPointCut <em>Selected Point Cut</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointCutPointCutImpl extends PointCutImpl implements PointCutPointCut {
	/**
	 * The cached value of the '{@link #getSelectedPointCut() <em>Selected Point Cut</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedPointCut()
	 * @generated
	 * @ordered
	 */
	protected PointCut selectedPointCut;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointCutPointCutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AspectjPackage.Literals.POINT_CUT_POINT_CUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCut getSelectedPointCut() {
		if (selectedPointCut != null && selectedPointCut.eIsProxy()) {
			InternalEObject oldSelectedPointCut = (InternalEObject)selectedPointCut;
			selectedPointCut = (PointCut)eResolveProxy(oldSelectedPointCut);
			if (selectedPointCut != oldSelectedPointCut) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT, oldSelectedPointCut, selectedPointCut));
			}
		}
		return selectedPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCut basicGetSelectedPointCut() {
		return selectedPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedPointCut(PointCut newSelectedPointCut) {
		PointCut oldSelectedPointCut = selectedPointCut;
		selectedPointCut = newSelectedPointCut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT, oldSelectedPointCut, selectedPointCut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT:
				if (resolve) return getSelectedPointCut();
				return basicGetSelectedPointCut();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT:
				setSelectedPointCut((PointCut)newValue);
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
			case AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT:
				setSelectedPointCut((PointCut)null);
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
			case AspectjPackage.POINT_CUT_POINT_CUT__SELECTED_POINT_CUT:
				return selectedPointCut != null;
		}
		return super.eIsSet(featureID);
	}

} //PointCutPointCutImpl
