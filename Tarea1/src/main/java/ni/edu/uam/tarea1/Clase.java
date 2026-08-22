package ni.edu.uam.tarea1;

public class Clase {

    private String nombre;
    private String profesor;
    private String fecha;
    private String aula;

    public Clase(String nombre, String profesor, String fecha, String aula) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.fecha = fecha;
        this.aula = aula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getAula() {
        return aula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}