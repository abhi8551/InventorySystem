package com.userSpringH2.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class ProductNotFoundException extends RuntimeException{

}
