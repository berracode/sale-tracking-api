package com.inerxia.saletrackingapi.exception;

import com.google.common.base.Joiner;
import com.inerxia.saletrackingapi.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<StandardResponse> handleDataNotFound(HttpServletRequest request, DataNotFoundException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public final ResponseEntity<StandardResponse> handleInsufficientStockException(HttpServletRequest request, InsufficientStockException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotEnabledLoginException.class)
    public final ResponseEntity<StandardResponse> handleUserNotEnabledLoginException(HttpServletRequest request, UserNotEnabledLoginException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(DataDuplicatedException.class)
    public final ResponseEntity<StandardResponse> handleDataDuplicated(HttpServletRequest request, DataDuplicatedException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRoleUserException.class)
    public final ResponseEntity<StandardResponse> handleInvalidRoleUserException(HttpServletRequest request, InvalidRoleUserException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataConstraintViolationException.class)
    public final ResponseEntity<StandardResponse> handleDataIntegrityViolation(HttpServletRequest request, DataConstraintViolationException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            String erorresMapeadosString = Joiner.on(",").withKeyValueSeparator("=").join(errors);

            return new ResponseEntity<Object>(
                    new StandardResponse(StandardResponse.StatusStandardResponse.ERROR, erorresMapeadosString),
                    HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(
                new StandardResponse(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public final ResponseEntity<StandardResponse> handleAccessDeniedException(HttpServletRequest request, AccessDeniedException ex){
        logger.error(request.getContextPath(), ex.toString());
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler({NumberFormatException.class})
    public final ResponseEntity<StandardResponse> handleNumberFormatException(HttpServletRequest request, NumberFormatException ex){
        logger.error(request.getContextPath(), ex.toString());
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error(request.getContextPath(), ex.toString());
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    /*
            Solución al error de no captura de la excepción ConstraintViolation

            La solución entonces es la respuesta en el link de abajo.

         * https://stackoverflow.com/questions/45070642/springboot-doesnt-handle-org-hibernate-exception-constraintviolationexception/61581127#61581127
         */
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public final ResponseEntity<StandardResponse> handleConstraintViolationException(Exception ex) {
        logger.error(ex.toString());

        return new ResponseEntity<>(
                new StandardResponse(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNoEncontradoException.class)
    public final ResponseEntity<StandardResponse> handleObjectNoEncontrado(HttpServletRequest request, ObjectNoEncontradoException ex){
        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<StandardResponse> handleDataIntegrityViolation(HttpServletRequest request, DataIntegrityViolationException ex){

        logger.error(request.getRequestURL().toString(), ex);
        return new ResponseEntity<>(new StandardResponse(
                StandardResponse.StatusStandardResponse.ERROR,
                ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }



}
