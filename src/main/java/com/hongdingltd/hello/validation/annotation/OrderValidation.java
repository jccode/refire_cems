package com.hongdingltd.hello.validation.annotation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by jcchen on 15-12-1.
 */
public class OrderValidation implements ConstraintValidator<Order, Object> {

    private String previousField;
    private String nextField;

    @Override
    public void initialize(Order order) {
        previousField = order.previous();
        nextField = order.next();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        Comparable previous = (Comparable) wrapper.getPropertyValue(previousField);
        Comparable next = (Comparable) wrapper.getPropertyValue(nextField);
        if (previous == null && next == null)
            return true;
        return next.compareTo(previous) > 0;
    }
}
