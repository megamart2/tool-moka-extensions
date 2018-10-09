/**
 */
package aspectj;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see aspectj.AspectjFactory
 * @model kind="package"
 * @generated
 */
public interface AspectjPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "aspectj";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://megamart2-ecsel.eu/aspectj";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "AspectJ";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AspectjPackage eINSTANCE = aspectj.impl.AspectjPackageImpl.init();

	/**
	 * The meta object id for the '{@link aspectj.impl.AspectImpl <em>Aspect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.AspectImpl
	 * @see aspectj.impl.AspectjPackageImpl#getAspect()
	 * @generated
	 */
	int ASPECT = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Is Privileged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__IS_PRIVILEGED = 1;

	/**
	 * The feature id for the '<em><b>Per Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__PER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Per Point Cut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__PER_POINT_CUT = 3;

	/**
	 * The feature id for the '<em><b>Declared Parents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__DECLARED_PARENTS = 4;

	/**
	 * The feature id for the '<em><b>Declared Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__DECLARED_IMPLEMENTS = 5;

	/**
	 * The feature id for the '<em><b>Precedes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__PRECEDES = 6;

	/**
	 * The feature id for the '<em><b>Preceded By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT__PRECEDED_BY = 7;

	/**
	 * The number of structural features of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Aspect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PointCutImpl <em>Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPointCut()
	 * @generated
	 */
	int POINT_CUT = 1;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT__BASE_STRUCTURAL_FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.OperationalPointCutImpl <em>Operational Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.OperationalPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getOperationalPointCut()
	 * @generated
	 */
	int OPERATIONAL_POINT_CUT = 2;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_POINT_CUT__OPERATION = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operational Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_POINT_CUT_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operational Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_POINT_CUT_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.WithinCodePointCutImpl <em>Within Code Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.WithinCodePointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getWithinCodePointCut()
	 * @generated
	 */
	int WITHIN_CODE_POINT_CUT = 3;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_CODE_POINT_CUT__BASE_STRUCTURAL_FEATURE = OPERATIONAL_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_CODE_POINT_CUT__OPERATION = OPERATIONAL_POINT_CUT__OPERATION;

	/**
	 * The number of structural features of the '<em>Within Code Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_CODE_POINT_CUT_FEATURE_COUNT = OPERATIONAL_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Within Code Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_CODE_POINT_CUT_OPERATION_COUNT = OPERATIONAL_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.ExecutionPointCutImpl <em>Execution Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.ExecutionPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getExecutionPointCut()
	 * @generated
	 */
	int EXECUTION_POINT_CUT = 4;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_POINT_CUT__BASE_STRUCTURAL_FEATURE = OPERATIONAL_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_POINT_CUT__OPERATION = OPERATIONAL_POINT_CUT__OPERATION;

	/**
	 * The number of structural features of the '<em>Execution Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_POINT_CUT_FEATURE_COUNT = OPERATIONAL_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Execution Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_POINT_CUT_OPERATION_COUNT = OPERATIONAL_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.CallPointCutImpl <em>Call Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.CallPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getCallPointCut()
	 * @generated
	 */
	int CALL_POINT_CUT = 5;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_POINT_CUT__BASE_STRUCTURAL_FEATURE = OPERATIONAL_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_POINT_CUT__OPERATION = OPERATIONAL_POINT_CUT__OPERATION;

	/**
	 * The number of structural features of the '<em>Call Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_POINT_CUT_FEATURE_COUNT = OPERATIONAL_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Call Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_POINT_CUT_OPERATION_COUNT = OPERATIONAL_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PreInitializationPointCutImpl <em>Pre Initialization Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PreInitializationPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPreInitializationPointCut()
	 * @generated
	 */
	int PRE_INITIALIZATION_POINT_CUT = 6;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_INITIALIZATION_POINT_CUT__BASE_STRUCTURAL_FEATURE = EXECUTION_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_INITIALIZATION_POINT_CUT__OPERATION = EXECUTION_POINT_CUT__OPERATION;

	/**
	 * The number of structural features of the '<em>Pre Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_INITIALIZATION_POINT_CUT_FEATURE_COUNT = EXECUTION_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pre Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_INITIALIZATION_POINT_CUT_OPERATION_COUNT = EXECUTION_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.InitializationPointCutImpl <em>Initialization Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.InitializationPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getInitializationPointCut()
	 * @generated
	 */
	int INITIALIZATION_POINT_CUT = 7;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_POINT_CUT__BASE_STRUCTURAL_FEATURE = EXECUTION_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_POINT_CUT__OPERATION = EXECUTION_POINT_CUT__OPERATION;

	/**
	 * The number of structural features of the '<em>Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_POINT_CUT_FEATURE_COUNT = EXECUTION_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_POINT_CUT_OPERATION_COUNT = EXECUTION_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PropertyPointCutImpl <em>Property Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PropertyPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPropertyPointCut()
	 * @generated
	 */
	int PROPERTY_POINT_CUT = 8;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_POINT_CUT__FIELD = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_POINT_CUT_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_POINT_CUT_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.GetPointCutImpl <em>Get Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.GetPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getGetPointCut()
	 * @generated
	 */
	int GET_POINT_CUT = 9;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POINT_CUT__BASE_STRUCTURAL_FEATURE = PROPERTY_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POINT_CUT__FIELD = PROPERTY_POINT_CUT__FIELD;

	/**
	 * The number of structural features of the '<em>Get Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POINT_CUT_FEATURE_COUNT = PROPERTY_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Get Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POINT_CUT_OPERATION_COUNT = PROPERTY_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.SetPointCutImpl <em>Set Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.SetPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getSetPointCut()
	 * @generated
	 */
	int SET_POINT_CUT = 10;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POINT_CUT__BASE_STRUCTURAL_FEATURE = PROPERTY_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POINT_CUT__FIELD = PROPERTY_POINT_CUT__FIELD;

	/**
	 * The number of structural features of the '<em>Set Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POINT_CUT_FEATURE_COUNT = PROPERTY_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Set Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POINT_CUT_OPERATION_COUNT = PROPERTY_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.TypePointCutImpl <em>Type Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.TypePointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getTypePointCut()
	 * @generated
	 */
	int TYPE_POINT_CUT = 11;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_POINT_CUT__TYPE = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_POINT_CUT_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_POINT_CUT_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.ThisPointCutImpl <em>This Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.ThisPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getThisPointCut()
	 * @generated
	 */
	int THIS_POINT_CUT = 12;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>This Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>This Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIS_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.ArgumentDefiningPointCutImpl <em>Argument Defining Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.ArgumentDefiningPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getArgumentDefiningPointCut()
	 * @generated
	 */
	int ARGUMENT_DEFINING_POINT_CUT = 13;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_DEFINING_POINT_CUT__BASE_STRUCTURAL_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Arg Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_DEFINING_POINT_CUT__ARG_NAMES = 1;

	/**
	 * The number of structural features of the '<em>Argument Defining Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_DEFINING_POINT_CUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Argument Defining Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_DEFINING_POINT_CUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.ArgsPointCutImpl <em>Args Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.ArgsPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getArgsPointCut()
	 * @generated
	 */
	int ARGS_POINT_CUT = 14;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGS_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGS_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>Args Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGS_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Args Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGS_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.TargetPointCutImpl <em>Target Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.TargetPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getTargetPointCut()
	 * @generated
	 */
	int TARGET_POINT_CUT = 15;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>Target Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Target Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PointCutPointCutImpl <em>Point Cut Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PointCutPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPointCutPointCut()
	 * @generated
	 */
	int POINT_CUT_POINT_CUT = 16;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Selected Point Cut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_POINT_CUT__SELECTED_POINT_CUT = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point Cut Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_POINT_CUT_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Point Cut Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_POINT_CUT_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.CFlowBelowPointCutImpl <em>CFlow Below Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.CFlowBelowPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getCFlowBelowPointCut()
	 * @generated
	 */
	int CFLOW_BELOW_POINT_CUT = 17;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_BELOW_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Selected Point Cut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_BELOW_POINT_CUT__SELECTED_POINT_CUT = POINT_CUT_POINT_CUT__SELECTED_POINT_CUT;

	/**
	 * The number of structural features of the '<em>CFlow Below Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_BELOW_POINT_CUT_FEATURE_COUNT = POINT_CUT_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CFlow Below Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_BELOW_POINT_CUT_OPERATION_COUNT = POINT_CUT_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.CFlowPointCutImpl <em>CFlow Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.CFlowPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getCFlowPointCut()
	 * @generated
	 */
	int CFLOW_POINT_CUT = 18;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Selected Point Cut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_POINT_CUT__SELECTED_POINT_CUT = POINT_CUT_POINT_CUT__SELECTED_POINT_CUT;

	/**
	 * The number of structural features of the '<em>CFlow Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_POINT_CUT_FEATURE_COUNT = POINT_CUT_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CFlow Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CFLOW_POINT_CUT_OPERATION_COUNT = POINT_CUT_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.StaticInitializationPointCutImpl <em>Static Initialization Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.StaticInitializationPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getStaticInitializationPointCut()
	 * @generated
	 */
	int STATIC_INITIALIZATION_POINT_CUT = 19;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_INITIALIZATION_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_INITIALIZATION_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>Static Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_INITIALIZATION_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Static Initialization Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_INITIALIZATION_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.ExceptionPointCutImpl <em>Exception Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.ExceptionPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getExceptionPointCut()
	 * @generated
	 */
	int EXCEPTION_POINT_CUT = 20;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>Exception Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exception Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPTION_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.WithinPointCutImpl <em>Within Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.WithinPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getWithinPointCut()
	 * @generated
	 */
	int WITHIN_POINT_CUT = 21;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_POINT_CUT__BASE_STRUCTURAL_FEATURE = TYPE_POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_POINT_CUT__TYPE = TYPE_POINT_CUT__TYPE;

	/**
	 * The number of structural features of the '<em>Within Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_POINT_CUT_FEATURE_COUNT = TYPE_POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Within Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITHIN_POINT_CUT_OPERATION_COUNT = TYPE_POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PointCutDisjunctionImpl <em>Point Cut Disjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PointCutDisjunctionImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPointCutDisjunction()
	 * @generated
	 */
	int POINT_CUT_DISJUNCTION = 22;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_DISJUNCTION__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Composee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_DISJUNCTION__COMPOSEE = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point Cut Disjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_DISJUNCTION_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Point Cut Disjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_DISJUNCTION_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PointCutConjunctionImpl <em>Point Cut Conjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PointCutConjunctionImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPointCutConjunction()
	 * @generated
	 */
	int POINT_CUT_CONJUNCTION = 23;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_CONJUNCTION__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Composee</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_CONJUNCTION__COMPOSEE = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point Cut Conjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_CONJUNCTION_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Point Cut Conjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_CONJUNCTION_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.PointCutNegationImpl <em>Point Cut Negation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.PointCutNegationImpl
	 * @see aspectj.impl.AspectjPackageImpl#getPointCutNegation()
	 * @generated
	 */
	int POINT_CUT_NEGATION = 24;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_NEGATION__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Composee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_NEGATION__COMPOSEE = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Point Cut Negation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_NEGATION_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Point Cut Negation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_CUT_NEGATION_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.AdviceImpl <em>Advice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.AdviceImpl
	 * @see aspectj.impl.AspectjPackageImpl#getAdvice()
	 * @generated
	 */
	int ADVICE = 25;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE__BASE_BEHAVIORAL_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Advice Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE__ADVICE_EXECUTION = 1;

	/**
	 * The feature id for the '<em><b>Pointcut</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE__POINTCUT = 2;

	/**
	 * The number of structural features of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.AdviceExecutionPointCutImpl <em>Advice Execution Point Cut</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.AdviceExecutionPointCutImpl
	 * @see aspectj.impl.AspectjPackageImpl#getAdviceExecutionPointCut()
	 * @generated
	 */
	int ADVICE_EXECUTION_POINT_CUT = 26;

	/**
	 * The feature id for the '<em><b>Base Structural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_EXECUTION_POINT_CUT__BASE_STRUCTURAL_FEATURE = POINT_CUT__BASE_STRUCTURAL_FEATURE;

	/**
	 * The number of structural features of the '<em>Advice Execution Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_EXECUTION_POINT_CUT_FEATURE_COUNT = POINT_CUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Advice Execution Point Cut</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_EXECUTION_POINT_CUT_OPERATION_COUNT = POINT_CUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.StaticCrossCuttingFeatureImpl <em>Static Cross Cutting Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.StaticCrossCuttingFeatureImpl
	 * @see aspectj.impl.AspectjPackageImpl#getStaticCrossCuttingFeature()
	 * @generated
	 */
	int STATIC_CROSS_CUTTING_FEATURE = 27;

	/**
	 * The feature id for the '<em><b>Base Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_CROSS_CUTTING_FEATURE__BASE_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>On Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_CROSS_CUTTING_FEATURE__ON_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Static Cross Cutting Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_CROSS_CUTTING_FEATURE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Static Cross Cutting Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_CROSS_CUTTING_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.impl.CrossCuttingConcernImpl <em>Cross Cutting Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.impl.CrossCuttingConcernImpl
	 * @see aspectj.impl.AspectjPackageImpl#getCrossCuttingConcern()
	 * @generated
	 */
	int CROSS_CUTTING_CONCERN = 28;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_CUTTING_CONCERN__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Cross Cutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_CUTTING_CONCERN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Cross Cutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSS_CUTTING_CONCERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link aspectj.AspectInstantiationType <em>Aspect Instantiation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.AspectInstantiationType
	 * @see aspectj.impl.AspectjPackageImpl#getAspectInstantiationType()
	 * @generated
	 */
	int ASPECT_INSTANTIATION_TYPE = 29;

	/**
	 * The meta object id for the '{@link aspectj.AdviceExecutionType <em>Advice Execution Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see aspectj.AdviceExecutionType
	 * @see aspectj.impl.AspectjPackageImpl#getAdviceExecutionType()
	 * @generated
	 */
	int ADVICE_EXECUTION_TYPE = 30;


	/**
	 * Returns the meta object for class '{@link aspectj.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect</em>'.
	 * @see aspectj.Aspect
	 * @generated
	 */
	EClass getAspect();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Aspect#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see aspectj.Aspect#getBase_Class()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link aspectj.Aspect#isPrivileged <em>Is Privileged</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Privileged</em>'.
	 * @see aspectj.Aspect#isPrivileged()
	 * @see #getAspect()
	 * @generated
	 */
	EAttribute getAspect_IsPrivileged();

	/**
	 * Returns the meta object for the attribute list '{@link aspectj.Aspect#getPerType <em>Per Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Per Type</em>'.
	 * @see aspectj.Aspect#getPerType()
	 * @see #getAspect()
	 * @generated
	 */
	EAttribute getAspect_PerType();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Aspect#getPerPointCut <em>Per Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Per Point Cut</em>'.
	 * @see aspectj.Aspect#getPerPointCut()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_PerPointCut();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.Aspect#getDeclaredParents <em>Declared Parents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Declared Parents</em>'.
	 * @see aspectj.Aspect#getDeclaredParents()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_DeclaredParents();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.Aspect#getDeclaredImplements <em>Declared Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Declared Implements</em>'.
	 * @see aspectj.Aspect#getDeclaredImplements()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_DeclaredImplements();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Aspect#getPrecedes <em>Precedes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Precedes</em>'.
	 * @see aspectj.Aspect#getPrecedes()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_Precedes();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Aspect#getPrecededBy <em>Preceded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Preceded By</em>'.
	 * @see aspectj.Aspect#getPrecededBy()
	 * @see #getAspect()
	 * @generated
	 */
	EReference getAspect_PrecededBy();

	/**
	 * Returns the meta object for class '{@link aspectj.PointCut <em>Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Cut</em>'.
	 * @see aspectj.PointCut
	 * @generated
	 */
	EClass getPointCut();

	/**
	 * Returns the meta object for the reference '{@link aspectj.PointCut#getBase_StructuralFeature <em>Base Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structural Feature</em>'.
	 * @see aspectj.PointCut#getBase_StructuralFeature()
	 * @see #getPointCut()
	 * @generated
	 */
	EReference getPointCut_Base_StructuralFeature();

	/**
	 * Returns the meta object for class '{@link aspectj.OperationalPointCut <em>Operational Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operational Point Cut</em>'.
	 * @see aspectj.OperationalPointCut
	 * @generated
	 */
	EClass getOperationalPointCut();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.OperationalPointCut#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operation</em>'.
	 * @see aspectj.OperationalPointCut#getOperation()
	 * @see #getOperationalPointCut()
	 * @generated
	 */
	EReference getOperationalPointCut_Operation();

	/**
	 * Returns the meta object for class '{@link aspectj.WithinCodePointCut <em>Within Code Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Within Code Point Cut</em>'.
	 * @see aspectj.WithinCodePointCut
	 * @generated
	 */
	EClass getWithinCodePointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.ExecutionPointCut <em>Execution Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Point Cut</em>'.
	 * @see aspectj.ExecutionPointCut
	 * @generated
	 */
	EClass getExecutionPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.CallPointCut <em>Call Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Point Cut</em>'.
	 * @see aspectj.CallPointCut
	 * @generated
	 */
	EClass getCallPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.PreInitializationPointCut <em>Pre Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Initialization Point Cut</em>'.
	 * @see aspectj.PreInitializationPointCut
	 * @generated
	 */
	EClass getPreInitializationPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.InitializationPointCut <em>Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initialization Point Cut</em>'.
	 * @see aspectj.InitializationPointCut
	 * @generated
	 */
	EClass getInitializationPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.PropertyPointCut <em>Property Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Point Cut</em>'.
	 * @see aspectj.PropertyPointCut
	 * @generated
	 */
	EClass getPropertyPointCut();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.PropertyPointCut#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Field</em>'.
	 * @see aspectj.PropertyPointCut#getField()
	 * @see #getPropertyPointCut()
	 * @generated
	 */
	EReference getPropertyPointCut_Field();

	/**
	 * Returns the meta object for class '{@link aspectj.GetPointCut <em>Get Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Point Cut</em>'.
	 * @see aspectj.GetPointCut
	 * @generated
	 */
	EClass getGetPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.SetPointCut <em>Set Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Point Cut</em>'.
	 * @see aspectj.SetPointCut
	 * @generated
	 */
	EClass getSetPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.TypePointCut <em>Type Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Point Cut</em>'.
	 * @see aspectj.TypePointCut
	 * @generated
	 */
	EClass getTypePointCut();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.TypePointCut#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type</em>'.
	 * @see aspectj.TypePointCut#getType()
	 * @see #getTypePointCut()
	 * @generated
	 */
	EReference getTypePointCut_Type();

	/**
	 * Returns the meta object for class '{@link aspectj.ThisPointCut <em>This Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>This Point Cut</em>'.
	 * @see aspectj.ThisPointCut
	 * @generated
	 */
	EClass getThisPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.ArgumentDefiningPointCut <em>Argument Defining Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument Defining Point Cut</em>'.
	 * @see aspectj.ArgumentDefiningPointCut
	 * @generated
	 */
	EClass getArgumentDefiningPointCut();

	/**
	 * Returns the meta object for the reference '{@link aspectj.ArgumentDefiningPointCut#getBase_StructuralFeature <em>Base Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structural Feature</em>'.
	 * @see aspectj.ArgumentDefiningPointCut#getBase_StructuralFeature()
	 * @see #getArgumentDefiningPointCut()
	 * @generated
	 */
	EReference getArgumentDefiningPointCut_Base_StructuralFeature();

	/**
	 * Returns the meta object for the attribute list '{@link aspectj.ArgumentDefiningPointCut#getArgNames <em>Arg Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Arg Names</em>'.
	 * @see aspectj.ArgumentDefiningPointCut#getArgNames()
	 * @see #getArgumentDefiningPointCut()
	 * @generated
	 */
	EAttribute getArgumentDefiningPointCut_ArgNames();

	/**
	 * Returns the meta object for class '{@link aspectj.ArgsPointCut <em>Args Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Args Point Cut</em>'.
	 * @see aspectj.ArgsPointCut
	 * @generated
	 */
	EClass getArgsPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.TargetPointCut <em>Target Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Point Cut</em>'.
	 * @see aspectj.TargetPointCut
	 * @generated
	 */
	EClass getTargetPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.PointCutPointCut <em>Point Cut Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Cut Point Cut</em>'.
	 * @see aspectj.PointCutPointCut
	 * @generated
	 */
	EClass getPointCutPointCut();

	/**
	 * Returns the meta object for the reference '{@link aspectj.PointCutPointCut#getSelectedPointCut <em>Selected Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selected Point Cut</em>'.
	 * @see aspectj.PointCutPointCut#getSelectedPointCut()
	 * @see #getPointCutPointCut()
	 * @generated
	 */
	EReference getPointCutPointCut_SelectedPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.CFlowBelowPointCut <em>CFlow Below Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CFlow Below Point Cut</em>'.
	 * @see aspectj.CFlowBelowPointCut
	 * @generated
	 */
	EClass getCFlowBelowPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.CFlowPointCut <em>CFlow Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CFlow Point Cut</em>'.
	 * @see aspectj.CFlowPointCut
	 * @generated
	 */
	EClass getCFlowPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.StaticInitializationPointCut <em>Static Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Initialization Point Cut</em>'.
	 * @see aspectj.StaticInitializationPointCut
	 * @generated
	 */
	EClass getStaticInitializationPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.ExceptionPointCut <em>Exception Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exception Point Cut</em>'.
	 * @see aspectj.ExceptionPointCut
	 * @generated
	 */
	EClass getExceptionPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.WithinPointCut <em>Within Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Within Point Cut</em>'.
	 * @see aspectj.WithinPointCut
	 * @generated
	 */
	EClass getWithinPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.PointCutDisjunction <em>Point Cut Disjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Cut Disjunction</em>'.
	 * @see aspectj.PointCutDisjunction
	 * @generated
	 */
	EClass getPointCutDisjunction();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.PointCutDisjunction#getComposee <em>Composee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composee</em>'.
	 * @see aspectj.PointCutDisjunction#getComposee()
	 * @see #getPointCutDisjunction()
	 * @generated
	 */
	EReference getPointCutDisjunction_Composee();

	/**
	 * Returns the meta object for class '{@link aspectj.PointCutConjunction <em>Point Cut Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Cut Conjunction</em>'.
	 * @see aspectj.PointCutConjunction
	 * @generated
	 */
	EClass getPointCutConjunction();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.PointCutConjunction#getComposee <em>Composee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composee</em>'.
	 * @see aspectj.PointCutConjunction#getComposee()
	 * @see #getPointCutConjunction()
	 * @generated
	 */
	EReference getPointCutConjunction_Composee();

	/**
	 * Returns the meta object for class '{@link aspectj.PointCutNegation <em>Point Cut Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Cut Negation</em>'.
	 * @see aspectj.PointCutNegation
	 * @generated
	 */
	EClass getPointCutNegation();

	/**
	 * Returns the meta object for the reference '{@link aspectj.PointCutNegation#getComposee <em>Composee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composee</em>'.
	 * @see aspectj.PointCutNegation#getComposee()
	 * @see #getPointCutNegation()
	 * @generated
	 */
	EReference getPointCutNegation_Composee();

	/**
	 * Returns the meta object for class '{@link aspectj.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice</em>'.
	 * @see aspectj.Advice
	 * @generated
	 */
	EClass getAdvice();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Advice#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see aspectj.Advice#getBase_BehavioralFeature()
	 * @see #getAdvice()
	 * @generated
	 */
	EReference getAdvice_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the attribute '{@link aspectj.Advice#getAdviceExecution <em>Advice Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Advice Execution</em>'.
	 * @see aspectj.Advice#getAdviceExecution()
	 * @see #getAdvice()
	 * @generated
	 */
	EAttribute getAdvice_AdviceExecution();

	/**
	 * Returns the meta object for the reference '{@link aspectj.Advice#getPointcut <em>Pointcut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pointcut</em>'.
	 * @see aspectj.Advice#getPointcut()
	 * @see #getAdvice()
	 * @generated
	 */
	EReference getAdvice_Pointcut();

	/**
	 * Returns the meta object for class '{@link aspectj.AdviceExecutionPointCut <em>Advice Execution Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice Execution Point Cut</em>'.
	 * @see aspectj.AdviceExecutionPointCut
	 * @generated
	 */
	EClass getAdviceExecutionPointCut();

	/**
	 * Returns the meta object for class '{@link aspectj.StaticCrossCuttingFeature <em>Static Cross Cutting Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Cross Cutting Feature</em>'.
	 * @see aspectj.StaticCrossCuttingFeature
	 * @generated
	 */
	EClass getStaticCrossCuttingFeature();

	/**
	 * Returns the meta object for the reference '{@link aspectj.StaticCrossCuttingFeature#getBase_Feature <em>Base Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Feature</em>'.
	 * @see aspectj.StaticCrossCuttingFeature#getBase_Feature()
	 * @see #getStaticCrossCuttingFeature()
	 * @generated
	 */
	EReference getStaticCrossCuttingFeature_Base_Feature();

	/**
	 * Returns the meta object for the reference list '{@link aspectj.StaticCrossCuttingFeature#getOnType <em>On Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Type</em>'.
	 * @see aspectj.StaticCrossCuttingFeature#getOnType()
	 * @see #getStaticCrossCuttingFeature()
	 * @generated
	 */
	EReference getStaticCrossCuttingFeature_OnType();

	/**
	 * Returns the meta object for class '{@link aspectj.CrossCuttingConcern <em>Cross Cutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cross Cutting Concern</em>'.
	 * @see aspectj.CrossCuttingConcern
	 * @generated
	 */
	EClass getCrossCuttingConcern();

	/**
	 * Returns the meta object for the reference '{@link aspectj.CrossCuttingConcern#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see aspectj.CrossCuttingConcern#getBase_Package()
	 * @see #getCrossCuttingConcern()
	 * @generated
	 */
	EReference getCrossCuttingConcern_Base_Package();

	/**
	 * Returns the meta object for enum '{@link aspectj.AspectInstantiationType <em>Aspect Instantiation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aspect Instantiation Type</em>'.
	 * @see aspectj.AspectInstantiationType
	 * @generated
	 */
	EEnum getAspectInstantiationType();

	/**
	 * Returns the meta object for enum '{@link aspectj.AdviceExecutionType <em>Advice Execution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Advice Execution Type</em>'.
	 * @see aspectj.AdviceExecutionType
	 * @generated
	 */
	EEnum getAdviceExecutionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AspectjFactory getAspectjFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link aspectj.impl.AspectImpl <em>Aspect</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.AspectImpl
		 * @see aspectj.impl.AspectjPackageImpl#getAspect()
		 * @generated
		 */
		EClass ASPECT = eINSTANCE.getAspect();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__BASE_CLASS = eINSTANCE.getAspect_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Is Privileged</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASPECT__IS_PRIVILEGED = eINSTANCE.getAspect_IsPrivileged();

		/**
		 * The meta object literal for the '<em><b>Per Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASPECT__PER_TYPE = eINSTANCE.getAspect_PerType();

		/**
		 * The meta object literal for the '<em><b>Per Point Cut</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__PER_POINT_CUT = eINSTANCE.getAspect_PerPointCut();

		/**
		 * The meta object literal for the '<em><b>Declared Parents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__DECLARED_PARENTS = eINSTANCE.getAspect_DeclaredParents();

		/**
		 * The meta object literal for the '<em><b>Declared Implements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__DECLARED_IMPLEMENTS = eINSTANCE.getAspect_DeclaredImplements();

		/**
		 * The meta object literal for the '<em><b>Precedes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__PRECEDES = eINSTANCE.getAspect_Precedes();

		/**
		 * The meta object literal for the '<em><b>Preceded By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASPECT__PRECEDED_BY = eINSTANCE.getAspect_PrecededBy();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PointCutImpl <em>Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPointCut()
		 * @generated
		 */
		EClass POINT_CUT = eINSTANCE.getPointCut();

		/**
		 * The meta object literal for the '<em><b>Base Structural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_CUT__BASE_STRUCTURAL_FEATURE = eINSTANCE.getPointCut_Base_StructuralFeature();

		/**
		 * The meta object literal for the '{@link aspectj.impl.OperationalPointCutImpl <em>Operational Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.OperationalPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getOperationalPointCut()
		 * @generated
		 */
		EClass OPERATIONAL_POINT_CUT = eINSTANCE.getOperationalPointCut();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONAL_POINT_CUT__OPERATION = eINSTANCE.getOperationalPointCut_Operation();

		/**
		 * The meta object literal for the '{@link aspectj.impl.WithinCodePointCutImpl <em>Within Code Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.WithinCodePointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getWithinCodePointCut()
		 * @generated
		 */
		EClass WITHIN_CODE_POINT_CUT = eINSTANCE.getWithinCodePointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.ExecutionPointCutImpl <em>Execution Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.ExecutionPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getExecutionPointCut()
		 * @generated
		 */
		EClass EXECUTION_POINT_CUT = eINSTANCE.getExecutionPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.CallPointCutImpl <em>Call Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.CallPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getCallPointCut()
		 * @generated
		 */
		EClass CALL_POINT_CUT = eINSTANCE.getCallPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PreInitializationPointCutImpl <em>Pre Initialization Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PreInitializationPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPreInitializationPointCut()
		 * @generated
		 */
		EClass PRE_INITIALIZATION_POINT_CUT = eINSTANCE.getPreInitializationPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.InitializationPointCutImpl <em>Initialization Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.InitializationPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getInitializationPointCut()
		 * @generated
		 */
		EClass INITIALIZATION_POINT_CUT = eINSTANCE.getInitializationPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PropertyPointCutImpl <em>Property Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PropertyPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPropertyPointCut()
		 * @generated
		 */
		EClass PROPERTY_POINT_CUT = eINSTANCE.getPropertyPointCut();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_POINT_CUT__FIELD = eINSTANCE.getPropertyPointCut_Field();

		/**
		 * The meta object literal for the '{@link aspectj.impl.GetPointCutImpl <em>Get Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.GetPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getGetPointCut()
		 * @generated
		 */
		EClass GET_POINT_CUT = eINSTANCE.getGetPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.SetPointCutImpl <em>Set Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.SetPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getSetPointCut()
		 * @generated
		 */
		EClass SET_POINT_CUT = eINSTANCE.getSetPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.TypePointCutImpl <em>Type Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.TypePointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getTypePointCut()
		 * @generated
		 */
		EClass TYPE_POINT_CUT = eINSTANCE.getTypePointCut();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_POINT_CUT__TYPE = eINSTANCE.getTypePointCut_Type();

		/**
		 * The meta object literal for the '{@link aspectj.impl.ThisPointCutImpl <em>This Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.ThisPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getThisPointCut()
		 * @generated
		 */
		EClass THIS_POINT_CUT = eINSTANCE.getThisPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.ArgumentDefiningPointCutImpl <em>Argument Defining Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.ArgumentDefiningPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getArgumentDefiningPointCut()
		 * @generated
		 */
		EClass ARGUMENT_DEFINING_POINT_CUT = eINSTANCE.getArgumentDefiningPointCut();

		/**
		 * The meta object literal for the '<em><b>Base Structural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT_DEFINING_POINT_CUT__BASE_STRUCTURAL_FEATURE = eINSTANCE.getArgumentDefiningPointCut_Base_StructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Arg Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT_DEFINING_POINT_CUT__ARG_NAMES = eINSTANCE.getArgumentDefiningPointCut_ArgNames();

		/**
		 * The meta object literal for the '{@link aspectj.impl.ArgsPointCutImpl <em>Args Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.ArgsPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getArgsPointCut()
		 * @generated
		 */
		EClass ARGS_POINT_CUT = eINSTANCE.getArgsPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.TargetPointCutImpl <em>Target Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.TargetPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getTargetPointCut()
		 * @generated
		 */
		EClass TARGET_POINT_CUT = eINSTANCE.getTargetPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PointCutPointCutImpl <em>Point Cut Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PointCutPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPointCutPointCut()
		 * @generated
		 */
		EClass POINT_CUT_POINT_CUT = eINSTANCE.getPointCutPointCut();

		/**
		 * The meta object literal for the '<em><b>Selected Point Cut</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_CUT_POINT_CUT__SELECTED_POINT_CUT = eINSTANCE.getPointCutPointCut_SelectedPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.CFlowBelowPointCutImpl <em>CFlow Below Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.CFlowBelowPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getCFlowBelowPointCut()
		 * @generated
		 */
		EClass CFLOW_BELOW_POINT_CUT = eINSTANCE.getCFlowBelowPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.CFlowPointCutImpl <em>CFlow Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.CFlowPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getCFlowPointCut()
		 * @generated
		 */
		EClass CFLOW_POINT_CUT = eINSTANCE.getCFlowPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.StaticInitializationPointCutImpl <em>Static Initialization Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.StaticInitializationPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getStaticInitializationPointCut()
		 * @generated
		 */
		EClass STATIC_INITIALIZATION_POINT_CUT = eINSTANCE.getStaticInitializationPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.ExceptionPointCutImpl <em>Exception Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.ExceptionPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getExceptionPointCut()
		 * @generated
		 */
		EClass EXCEPTION_POINT_CUT = eINSTANCE.getExceptionPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.WithinPointCutImpl <em>Within Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.WithinPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getWithinPointCut()
		 * @generated
		 */
		EClass WITHIN_POINT_CUT = eINSTANCE.getWithinPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PointCutDisjunctionImpl <em>Point Cut Disjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PointCutDisjunctionImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPointCutDisjunction()
		 * @generated
		 */
		EClass POINT_CUT_DISJUNCTION = eINSTANCE.getPointCutDisjunction();

		/**
		 * The meta object literal for the '<em><b>Composee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_CUT_DISJUNCTION__COMPOSEE = eINSTANCE.getPointCutDisjunction_Composee();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PointCutConjunctionImpl <em>Point Cut Conjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PointCutConjunctionImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPointCutConjunction()
		 * @generated
		 */
		EClass POINT_CUT_CONJUNCTION = eINSTANCE.getPointCutConjunction();

		/**
		 * The meta object literal for the '<em><b>Composee</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_CUT_CONJUNCTION__COMPOSEE = eINSTANCE.getPointCutConjunction_Composee();

		/**
		 * The meta object literal for the '{@link aspectj.impl.PointCutNegationImpl <em>Point Cut Negation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.PointCutNegationImpl
		 * @see aspectj.impl.AspectjPackageImpl#getPointCutNegation()
		 * @generated
		 */
		EClass POINT_CUT_NEGATION = eINSTANCE.getPointCutNegation();

		/**
		 * The meta object literal for the '<em><b>Composee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_CUT_NEGATION__COMPOSEE = eINSTANCE.getPointCutNegation_Composee();

		/**
		 * The meta object literal for the '{@link aspectj.impl.AdviceImpl <em>Advice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.AdviceImpl
		 * @see aspectj.impl.AspectjPackageImpl#getAdvice()
		 * @generated
		 */
		EClass ADVICE = eINSTANCE.getAdvice();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVICE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getAdvice_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Advice Execution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVICE__ADVICE_EXECUTION = eINSTANCE.getAdvice_AdviceExecution();

		/**
		 * The meta object literal for the '<em><b>Pointcut</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVICE__POINTCUT = eINSTANCE.getAdvice_Pointcut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.AdviceExecutionPointCutImpl <em>Advice Execution Point Cut</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.AdviceExecutionPointCutImpl
		 * @see aspectj.impl.AspectjPackageImpl#getAdviceExecutionPointCut()
		 * @generated
		 */
		EClass ADVICE_EXECUTION_POINT_CUT = eINSTANCE.getAdviceExecutionPointCut();

		/**
		 * The meta object literal for the '{@link aspectj.impl.StaticCrossCuttingFeatureImpl <em>Static Cross Cutting Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.StaticCrossCuttingFeatureImpl
		 * @see aspectj.impl.AspectjPackageImpl#getStaticCrossCuttingFeature()
		 * @generated
		 */
		EClass STATIC_CROSS_CUTTING_FEATURE = eINSTANCE.getStaticCrossCuttingFeature();

		/**
		 * The meta object literal for the '<em><b>Base Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_CROSS_CUTTING_FEATURE__BASE_FEATURE = eINSTANCE.getStaticCrossCuttingFeature_Base_Feature();

		/**
		 * The meta object literal for the '<em><b>On Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATIC_CROSS_CUTTING_FEATURE__ON_TYPE = eINSTANCE.getStaticCrossCuttingFeature_OnType();

		/**
		 * The meta object literal for the '{@link aspectj.impl.CrossCuttingConcernImpl <em>Cross Cutting Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.impl.CrossCuttingConcernImpl
		 * @see aspectj.impl.AspectjPackageImpl#getCrossCuttingConcern()
		 * @generated
		 */
		EClass CROSS_CUTTING_CONCERN = eINSTANCE.getCrossCuttingConcern();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSS_CUTTING_CONCERN__BASE_PACKAGE = eINSTANCE.getCrossCuttingConcern_Base_Package();

		/**
		 * The meta object literal for the '{@link aspectj.AspectInstantiationType <em>Aspect Instantiation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.AspectInstantiationType
		 * @see aspectj.impl.AspectjPackageImpl#getAspectInstantiationType()
		 * @generated
		 */
		EEnum ASPECT_INSTANTIATION_TYPE = eINSTANCE.getAspectInstantiationType();

		/**
		 * The meta object literal for the '{@link aspectj.AdviceExecutionType <em>Advice Execution Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see aspectj.AdviceExecutionType
		 * @see aspectj.impl.AspectjPackageImpl#getAdviceExecutionType()
		 * @generated
		 */
		EEnum ADVICE_EXECUTION_TYPE = eINSTANCE.getAdviceExecutionType();

	}

} //AspectjPackage
