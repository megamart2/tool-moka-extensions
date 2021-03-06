/**
 */
package aspectj.impl;

import aspectj.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AspectjFactoryImpl extends EFactoryImpl implements AspectjFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AspectjFactory init() {
		try {
			AspectjFactory theAspectjFactory = (AspectjFactory)EPackage.Registry.INSTANCE.getEFactory(AspectjPackage.eNS_URI);
			if (theAspectjFactory != null) {
				return theAspectjFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AspectjFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectjFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AspectjPackage.ASPECT: return createAspect();
			case AspectjPackage.POINT_CUT: return createPointCut();
			case AspectjPackage.OPERATIONAL_POINT_CUT: return createOperationalPointCut();
			case AspectjPackage.WITHIN_CODE_POINT_CUT: return createWithinCodePointCut();
			case AspectjPackage.EXECUTION_POINT_CUT: return createExecutionPointCut();
			case AspectjPackage.CALL_POINT_CUT: return createCallPointCut();
			case AspectjPackage.PRE_INITIALIZATION_POINT_CUT: return createPreInitializationPointCut();
			case AspectjPackage.INITIALIZATION_POINT_CUT: return createInitializationPointCut();
			case AspectjPackage.PROPERTY_POINT_CUT: return createPropertyPointCut();
			case AspectjPackage.GET_POINT_CUT: return createGetPointCut();
			case AspectjPackage.SET_POINT_CUT: return createSetPointCut();
			case AspectjPackage.TYPE_POINT_CUT: return createTypePointCut();
			case AspectjPackage.THIS_POINT_CUT: return createThisPointCut();
			case AspectjPackage.ARGUMENT_DEFINING_POINT_CUT: return createArgumentDefiningPointCut();
			case AspectjPackage.ARGS_POINT_CUT: return createArgsPointCut();
			case AspectjPackage.TARGET_POINT_CUT: return createTargetPointCut();
			case AspectjPackage.POINT_CUT_POINT_CUT: return createPointCutPointCut();
			case AspectjPackage.CFLOW_BELOW_POINT_CUT: return createCFlowBelowPointCut();
			case AspectjPackage.CFLOW_POINT_CUT: return createCFlowPointCut();
			case AspectjPackage.STATIC_INITIALIZATION_POINT_CUT: return createStaticInitializationPointCut();
			case AspectjPackage.EXCEPTION_POINT_CUT: return createExceptionPointCut();
			case AspectjPackage.WITHIN_POINT_CUT: return createWithinPointCut();
			case AspectjPackage.POINT_CUT_DISJUNCTION: return createPointCutDisjunction();
			case AspectjPackage.POINT_CUT_CONJUNCTION: return createPointCutConjunction();
			case AspectjPackage.POINT_CUT_NEGATION: return createPointCutNegation();
			case AspectjPackage.ADVICE: return createAdvice();
			case AspectjPackage.ADVICE_EXECUTION_POINT_CUT: return createAdviceExecutionPointCut();
			case AspectjPackage.STATIC_CROSS_CUTTING_FEATURE: return createStaticCrossCuttingFeature();
			case AspectjPackage.CROSS_CUTTING_CONCERN: return createCrossCuttingConcern();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AspectjPackage.ASPECT_INSTANTIATION_TYPE:
				return createAspectInstantiationTypeFromString(eDataType, initialValue);
			case AspectjPackage.ADVICE_EXECUTION_TYPE:
				return createAdviceExecutionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AspectjPackage.ASPECT_INSTANTIATION_TYPE:
				return convertAspectInstantiationTypeToString(eDataType, instanceValue);
			case AspectjPackage.ADVICE_EXECUTION_TYPE:
				return convertAdviceExecutionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect createAspect() {
		AspectImpl aspect = new AspectImpl();
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCut createPointCut() {
		PointCutImpl pointCut = new PointCutImpl();
		return pointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationalPointCut createOperationalPointCut() {
		OperationalPointCutImpl operationalPointCut = new OperationalPointCutImpl();
		return operationalPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WithinCodePointCut createWithinCodePointCut() {
		WithinCodePointCutImpl withinCodePointCut = new WithinCodePointCutImpl();
		return withinCodePointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionPointCut createExecutionPointCut() {
		ExecutionPointCutImpl executionPointCut = new ExecutionPointCutImpl();
		return executionPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallPointCut createCallPointCut() {
		CallPointCutImpl callPointCut = new CallPointCutImpl();
		return callPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreInitializationPointCut createPreInitializationPointCut() {
		PreInitializationPointCutImpl preInitializationPointCut = new PreInitializationPointCutImpl();
		return preInitializationPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitializationPointCut createInitializationPointCut() {
		InitializationPointCutImpl initializationPointCut = new InitializationPointCutImpl();
		return initializationPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyPointCut createPropertyPointCut() {
		PropertyPointCutImpl propertyPointCut = new PropertyPointCutImpl();
		return propertyPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetPointCut createGetPointCut() {
		GetPointCutImpl getPointCut = new GetPointCutImpl();
		return getPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetPointCut createSetPointCut() {
		SetPointCutImpl setPointCut = new SetPointCutImpl();
		return setPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypePointCut createTypePointCut() {
		TypePointCutImpl typePointCut = new TypePointCutImpl();
		return typePointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThisPointCut createThisPointCut() {
		ThisPointCutImpl thisPointCut = new ThisPointCutImpl();
		return thisPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgumentDefiningPointCut createArgumentDefiningPointCut() {
		ArgumentDefiningPointCutImpl argumentDefiningPointCut = new ArgumentDefiningPointCutImpl();
		return argumentDefiningPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgsPointCut createArgsPointCut() {
		ArgsPointCutImpl argsPointCut = new ArgsPointCutImpl();
		return argsPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPointCut createTargetPointCut() {
		TargetPointCutImpl targetPointCut = new TargetPointCutImpl();
		return targetPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCutPointCut createPointCutPointCut() {
		PointCutPointCutImpl pointCutPointCut = new PointCutPointCutImpl();
		return pointCutPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFlowBelowPointCut createCFlowBelowPointCut() {
		CFlowBelowPointCutImpl cFlowBelowPointCut = new CFlowBelowPointCutImpl();
		return cFlowBelowPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFlowPointCut createCFlowPointCut() {
		CFlowPointCutImpl cFlowPointCut = new CFlowPointCutImpl();
		return cFlowPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticInitializationPointCut createStaticInitializationPointCut() {
		StaticInitializationPointCutImpl staticInitializationPointCut = new StaticInitializationPointCutImpl();
		return staticInitializationPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionPointCut createExceptionPointCut() {
		ExceptionPointCutImpl exceptionPointCut = new ExceptionPointCutImpl();
		return exceptionPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WithinPointCut createWithinPointCut() {
		WithinPointCutImpl withinPointCut = new WithinPointCutImpl();
		return withinPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCutDisjunction createPointCutDisjunction() {
		PointCutDisjunctionImpl pointCutDisjunction = new PointCutDisjunctionImpl();
		return pointCutDisjunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCutConjunction createPointCutConjunction() {
		PointCutConjunctionImpl pointCutConjunction = new PointCutConjunctionImpl();
		return pointCutConjunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointCutNegation createPointCutNegation() {
		PointCutNegationImpl pointCutNegation = new PointCutNegationImpl();
		return pointCutNegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Advice createAdvice() {
		AdviceImpl advice = new AdviceImpl();
		return advice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdviceExecutionPointCut createAdviceExecutionPointCut() {
		AdviceExecutionPointCutImpl adviceExecutionPointCut = new AdviceExecutionPointCutImpl();
		return adviceExecutionPointCut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticCrossCuttingFeature createStaticCrossCuttingFeature() {
		StaticCrossCuttingFeatureImpl staticCrossCuttingFeature = new StaticCrossCuttingFeatureImpl();
		return staticCrossCuttingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrossCuttingConcern createCrossCuttingConcern() {
		CrossCuttingConcernImpl crossCuttingConcern = new CrossCuttingConcernImpl();
		return crossCuttingConcern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectInstantiationType createAspectInstantiationTypeFromString(EDataType eDataType, String initialValue) {
		AspectInstantiationType result = AspectInstantiationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAspectInstantiationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdviceExecutionType createAdviceExecutionTypeFromString(EDataType eDataType, String initialValue) {
		AdviceExecutionType result = AdviceExecutionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdviceExecutionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectjPackage getAspectjPackage() {
		return (AspectjPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AspectjPackage getPackage() {
		return AspectjPackage.eINSTANCE;
	}

} //AspectjFactoryImpl
