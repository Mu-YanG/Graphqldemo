package space.lvyang.graphql.demo.intercept;


import graphql.ExecutionResult;

import graphql.execution.instrumentation.*;
import graphql.execution.instrumentation.parameters.*;
import graphql.language.Document;

import graphql.validation.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

import static graphql.servlet.AbstractGraphQLHttpServlet.log;

@Slf4j

public class  GraphqlIntercept   implements Instrumentation {


    @Override
    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters instrumentationExecutionParameters) {

      log.debug("--------------"+instrumentationExecutionParameters.getQuery());
        log.debug(instrumentationExecutionParameters.toString());

        return null;
    }

    @Override
    public InstrumentationContext<Document> beginParse(InstrumentationExecutionParameters instrumentationExecutionParameters) {
        return null;
    }

    @Override
    public InstrumentationContext<List<ValidationError>> beginValidation(InstrumentationValidationParameters instrumentationValidationParameters) {
        return null;
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginExecuteOperation(InstrumentationExecuteOperationParameters instrumentationExecuteOperationParameters) {
        return null;
    }

    @Override
    public ExecutionStrategyInstrumentationContext beginExecutionStrategy(InstrumentationExecutionStrategyParameters instrumentationExecutionStrategyParameters) {
        return null;
    }

    @Override
    public DeferredFieldInstrumentationContext beginDeferredField(InstrumentationDeferredFieldParameters instrumentationDeferredFieldParameters) {
        return null;
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginField(InstrumentationFieldParameters instrumentationFieldParameters) {
        return null;
    }

    @Override
    public InstrumentationContext<Object> beginFieldFetch(InstrumentationFieldFetchParameters instrumentationFieldFetchParameters) {
        return null;
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldComplete(InstrumentationFieldCompleteParameters parameters) {
        return null;
    }

    @Override
    public InstrumentationContext<ExecutionResult> beginFieldListComplete(InstrumentationFieldCompleteParameters parameters) {
        return null;
    }

}
