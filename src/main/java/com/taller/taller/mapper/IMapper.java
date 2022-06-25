package com.taller.taller.mapper;

public interface IMapper<I,O> {
    public O map(I in);
}
