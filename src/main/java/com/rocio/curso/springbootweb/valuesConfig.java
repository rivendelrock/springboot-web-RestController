package com.rocio.curso.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//Si queremos usar más de un archivo de properties usamos llaves y comas para cada caso
@PropertySources({
@PropertySource("classpath:values.properties")
})
public class valuesConfig {

}
