package ksiegarnia.web.rest.dto;

import lombok.Data;

@Data
public class KsiazkaDTO {
    private String tytul;
    private Integer autorId;
    private float ocena;
}
