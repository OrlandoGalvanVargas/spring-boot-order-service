package com.practica.order_service.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id){
        super("No se encontró la orden con el id: " + id);
    }
}
