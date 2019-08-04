package org.py.jpure.support.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class UrlModel implements Serializable {
    private static final long serialVersionUID = 3980190109737201187L;
    private String home;
    private String controller;
    private String method;
    private String[] params;
}
