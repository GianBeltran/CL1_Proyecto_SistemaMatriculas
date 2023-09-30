package pe.edu.cibertec.cl1_matriculas.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "pagos")
@Getter @Setter @NoArgsConstructor
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;

    @ManyToOne @JoinColumn(name = "idmatricula")
    private Matricula matricula;

    @Column(name = "fechapago")
    private Date fechapago;
    @Column(name = "montopago")
    private Double montopago;
    @Column(name = "estadopago")
    private Integer estadopago;
}
