/**
 */
package aspectj.util;

import aspectj.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see aspectj.AspectjPackage
 * @generated
 */
public class AspectjAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AspectjPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AspectjAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AspectjPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectjSwitch<Adapter> modelSwitch =
		new AspectjSwitch<Adapter>() {
			@Override
			public Adapter caseAspect(Aspect object) {
				return createAspectAdapter();
			}
			@Override
			public Adapter casePointCut(PointCut object) {
				return createPointCutAdapter();
			}
			@Override
			public Adapter caseOperationalPointCut(OperationalPointCut object) {
				return createOperationalPointCutAdapter();
			}
			@Override
			public Adapter caseWithinCodePointCut(WithinCodePointCut object) {
				return createWithinCodePointCutAdapter();
			}
			@Override
			public Adapter caseExecutionPointCut(ExecutionPointCut object) {
				return createExecutionPointCutAdapter();
			}
			@Override
			public Adapter caseCallPointCut(CallPointCut object) {
				return createCallPointCutAdapter();
			}
			@Override
			public Adapter casePreInitializationPointCut(PreInitializationPointCut object) {
				return createPreInitializationPointCutAdapter();
			}
			@Override
			public Adapter caseInitializationPointCut(InitializationPointCut object) {
				return createInitializationPointCutAdapter();
			}
			@Override
			public Adapter casePropertyPointCut(PropertyPointCut object) {
				return createPropertyPointCutAdapter();
			}
			@Override
			public Adapter caseGetPointCut(GetPointCut object) {
				return createGetPointCutAdapter();
			}
			@Override
			public Adapter caseSetPointCut(SetPointCut object) {
				return createSetPointCutAdapter();
			}
			@Override
			public Adapter caseTypePointCut(TypePointCut object) {
				return createTypePointCutAdapter();
			}
			@Override
			public Adapter caseThisPointCut(ThisPointCut object) {
				return createThisPointCutAdapter();
			}
			@Override
			public Adapter caseArgumentDefiningPointCut(ArgumentDefiningPointCut object) {
				return createArgumentDefiningPointCutAdapter();
			}
			@Override
			public Adapter caseArgsPointCut(ArgsPointCut object) {
				return createArgsPointCutAdapter();
			}
			@Override
			public Adapter caseTargetPointCut(TargetPointCut object) {
				return createTargetPointCutAdapter();
			}
			@Override
			public Adapter casePointCutPointCut(PointCutPointCut object) {
				return createPointCutPointCutAdapter();
			}
			@Override
			public Adapter caseCFlowBelowPointCut(CFlowBelowPointCut object) {
				return createCFlowBelowPointCutAdapter();
			}
			@Override
			public Adapter caseCFlowPointCut(CFlowPointCut object) {
				return createCFlowPointCutAdapter();
			}
			@Override
			public Adapter caseStaticInitializationPointCut(StaticInitializationPointCut object) {
				return createStaticInitializationPointCutAdapter();
			}
			@Override
			public Adapter caseExceptionPointCut(ExceptionPointCut object) {
				return createExceptionPointCutAdapter();
			}
			@Override
			public Adapter caseWithinPointCut(WithinPointCut object) {
				return createWithinPointCutAdapter();
			}
			@Override
			public Adapter casePointCutDisjunction(PointCutDisjunction object) {
				return createPointCutDisjunctionAdapter();
			}
			@Override
			public Adapter casePointCutConjunction(PointCutConjunction object) {
				return createPointCutConjunctionAdapter();
			}
			@Override
			public Adapter casePointCutNegation(PointCutNegation object) {
				return createPointCutNegationAdapter();
			}
			@Override
			public Adapter caseAdvice(Advice object) {
				return createAdviceAdapter();
			}
			@Override
			public Adapter caseAdviceExecutionPointCut(AdviceExecutionPointCut object) {
				return createAdviceExecutionPointCutAdapter();
			}
			@Override
			public Adapter caseStaticCrossCuttingFeature(StaticCrossCuttingFeature object) {
				return createStaticCrossCuttingFeatureAdapter();
			}
			@Override
			public Adapter caseCrossCuttingConcern(CrossCuttingConcern object) {
				return createCrossCuttingConcernAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link aspectj.Aspect <em>Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.Aspect
	 * @generated
	 */
	public Adapter createAspectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PointCut <em>Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PointCut
	 * @generated
	 */
	public Adapter createPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.OperationalPointCut <em>Operational Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.OperationalPointCut
	 * @generated
	 */
	public Adapter createOperationalPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.WithinCodePointCut <em>Within Code Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.WithinCodePointCut
	 * @generated
	 */
	public Adapter createWithinCodePointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.ExecutionPointCut <em>Execution Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.ExecutionPointCut
	 * @generated
	 */
	public Adapter createExecutionPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.CallPointCut <em>Call Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.CallPointCut
	 * @generated
	 */
	public Adapter createCallPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PreInitializationPointCut <em>Pre Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PreInitializationPointCut
	 * @generated
	 */
	public Adapter createPreInitializationPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.InitializationPointCut <em>Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.InitializationPointCut
	 * @generated
	 */
	public Adapter createInitializationPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PropertyPointCut <em>Property Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PropertyPointCut
	 * @generated
	 */
	public Adapter createPropertyPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.GetPointCut <em>Get Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.GetPointCut
	 * @generated
	 */
	public Adapter createGetPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.SetPointCut <em>Set Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.SetPointCut
	 * @generated
	 */
	public Adapter createSetPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.TypePointCut <em>Type Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.TypePointCut
	 * @generated
	 */
	public Adapter createTypePointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.ThisPointCut <em>This Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.ThisPointCut
	 * @generated
	 */
	public Adapter createThisPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.ArgumentDefiningPointCut <em>Argument Defining Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.ArgumentDefiningPointCut
	 * @generated
	 */
	public Adapter createArgumentDefiningPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.ArgsPointCut <em>Args Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.ArgsPointCut
	 * @generated
	 */
	public Adapter createArgsPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.TargetPointCut <em>Target Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.TargetPointCut
	 * @generated
	 */
	public Adapter createTargetPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PointCutPointCut <em>Point Cut Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PointCutPointCut
	 * @generated
	 */
	public Adapter createPointCutPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.CFlowBelowPointCut <em>CFlow Below Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.CFlowBelowPointCut
	 * @generated
	 */
	public Adapter createCFlowBelowPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.CFlowPointCut <em>CFlow Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.CFlowPointCut
	 * @generated
	 */
	public Adapter createCFlowPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.StaticInitializationPointCut <em>Static Initialization Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.StaticInitializationPointCut
	 * @generated
	 */
	public Adapter createStaticInitializationPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.ExceptionPointCut <em>Exception Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.ExceptionPointCut
	 * @generated
	 */
	public Adapter createExceptionPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.WithinPointCut <em>Within Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.WithinPointCut
	 * @generated
	 */
	public Adapter createWithinPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PointCutDisjunction <em>Point Cut Disjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PointCutDisjunction
	 * @generated
	 */
	public Adapter createPointCutDisjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PointCutConjunction <em>Point Cut Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PointCutConjunction
	 * @generated
	 */
	public Adapter createPointCutConjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.PointCutNegation <em>Point Cut Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.PointCutNegation
	 * @generated
	 */
	public Adapter createPointCutNegationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.Advice
	 * @generated
	 */
	public Adapter createAdviceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.AdviceExecutionPointCut <em>Advice Execution Point Cut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.AdviceExecutionPointCut
	 * @generated
	 */
	public Adapter createAdviceExecutionPointCutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.StaticCrossCuttingFeature <em>Static Cross Cutting Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.StaticCrossCuttingFeature
	 * @generated
	 */
	public Adapter createStaticCrossCuttingFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link aspectj.CrossCuttingConcern <em>Cross Cutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see aspectj.CrossCuttingConcern
	 * @generated
	 */
	public Adapter createCrossCuttingConcernAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AspectjAdapterFactory
