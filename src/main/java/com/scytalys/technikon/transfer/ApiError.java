package com.scytalys.technikon.transfer;

public record ApiError(Integer status, String message, String path) {
}
