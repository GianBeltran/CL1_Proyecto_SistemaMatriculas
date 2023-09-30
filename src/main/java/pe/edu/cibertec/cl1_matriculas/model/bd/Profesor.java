package pe.edu.cibertec.cl1_matriculas.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profesores")
@Getter @Setter @NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprofesor;

    @Column(name = "nomprofesor")
    private String nomprofesor;
    @Column(name = "apeprofesor")
    private String apeprofesor;
    @Column(name = "correo")
    private String correo;
}
