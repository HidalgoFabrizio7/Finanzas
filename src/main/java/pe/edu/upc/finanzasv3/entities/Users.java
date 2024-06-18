package pe.edu.upc.finanzasv3.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 200)
    private String password;
    @Column(nullable = true)
    private Boolean enabled;

    //El resto de usuario
    @Column(name ="nombreUsuario", nullable = true, length = 45)
    private String nombreUsuario;
    @Column(name ="apellidoUsuario", nullable = true, length = 45)
    private String apellidoUsuario;
    @Column(name ="nombreEmpresaUsuario", nullable = true, length = 45)
    private String nombreEmpresaUsuario;
    @Column(name ="correoUsuario", nullable = true, length = 45)
    private String correoUsuario;
    @Column(name ="celularUsuario", nullable = true, length = 45)
    private String celularUsuario;
    @Column(name ="DNIUsuario", nullable = true, length = 45)
    private String DNIUsuario;
    @Column(name ="direccionUsuario", nullable = true, length = 45)
    private String direccionUsuario;
    @Column(name ="estadoUsuario", nullable = true, length = 45)
    private String estadoUsuario;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users() {
    }

    public Users(Long id, String username, String password, Boolean enabled, String nombreUsuario, String apellidoUsuario, String nombreEmpresaUsuario, String correoUsuario, String celularUsuario, String DNIUsuario, String direccionUsuario, String estadoUsuario, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nombreEmpresaUsuario = nombreEmpresaUsuario;
        this.correoUsuario = correoUsuario;
        this.celularUsuario = celularUsuario;
        this.DNIUsuario = DNIUsuario;
        this.direccionUsuario = direccionUsuario;
        this.estadoUsuario = estadoUsuario;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNombreEmpresaUsuario() {
        return nombreEmpresaUsuario;
    }

    public void setNombreEmpresaUsuario(String nombreEmpresaUsuario) {
        this.nombreEmpresaUsuario = nombreEmpresaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getCelularUsuario() {
        return celularUsuario;
    }

    public void setCelularUsuario(String celularUsuario) {
        this.celularUsuario = celularUsuario;
    }

    public String getDNIUsuario() {
        return DNIUsuario;
    }

    public void setDNIUsuario(String DNIUsuario) {
        this.DNIUsuario = DNIUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
