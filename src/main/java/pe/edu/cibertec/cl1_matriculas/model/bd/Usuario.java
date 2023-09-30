package pe.edu.cibertec.cl1_matriculas.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;

    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;

    @ManyToOne @JoinColumn(name = "idrol")
    private Rol rol;
}
