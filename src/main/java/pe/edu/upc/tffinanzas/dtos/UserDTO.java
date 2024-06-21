package pe.edu.upc.tffinanzas.dtos;

public class UserDTO {
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;

    //El resto de usuario
    private String nombreUsuario;
    private String apellidoUsuario;
    private String nombreEmpresaUsuario;
    private String correoUsuario;
    private String celularUsuario;
    private String DNIUsuario;
    private String direccionUsuario;

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
}
