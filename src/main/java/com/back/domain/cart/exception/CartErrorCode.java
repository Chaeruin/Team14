package com.back.domain.cart.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CartErrorCode {
    CART_NOT_FOUND(HttpStatus.NOT_FOUND, "CART-404", "해당 장바구니를 찾을 수 없습니다."),
    CART_ALREADY_EXISTS(HttpStatus.CONFLICT, "CART-409", "이미 장바구니가 존재합니다."),
    CART_ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "CART-414", "해당 장바구니 아이템을 찾을 수 없습니다."),
    CARTITEM_OWNER_MISMATCH(HttpStatus.NOT_FOUND, "CART-424", "장바구니 아이템 소유자와 요청한 회원이 일치하지 않습니다."),;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}