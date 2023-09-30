package pe.edu.cibertec.cl1_matriculas.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "estudiantes")
@Getter @Setter @NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestudiante;

    @Column(name = "nomestudiante")
    private String nomestudiante;
    @Column(name = "apeestudiante")
    private String apeestudiante;
    @Column(name = "fechanac")
    private Date fechanac;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "grado")
    private String grado;

}
