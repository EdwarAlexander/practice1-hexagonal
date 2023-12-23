package com.hexa.moran.domain.ports.crud;

import java.util.Optional;

public interface Crud<RQ,RS,ID>{
    RS create(RQ request);
    Optional<RS> update(ID code,RQ request);
    Optional<RS> get(ID code);
    boolean delete(ID code);
}
