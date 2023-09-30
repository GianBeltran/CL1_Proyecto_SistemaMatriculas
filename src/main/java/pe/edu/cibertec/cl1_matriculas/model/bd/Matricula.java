package pe.edu.cibertec.cl1_matriculas.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "matriculas")
@Getter @Setter @NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmatricula;

    @OneToOne @JoinColumn(name = "idestudiante")
    private Estudiante estudiante;

    @Column(name = "yearacademico")
    private Integer yearacademico;
    @Column(name = "fechmatric")
    private Date fechmatric;
    @Column(name = "estadomatri")
    private Integer estadomatri;
}
