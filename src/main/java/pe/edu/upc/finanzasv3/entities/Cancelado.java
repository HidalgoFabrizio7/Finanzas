package pe.edu.upc.finanzasv3.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Cancelado")
public class Cancelado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCancelado;
}
