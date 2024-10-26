package appointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment(appointment.getAppointmentId()));
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment);
        service.deleteAppointment(appointment.getAppointmentId());
        assertNull(service.getAppointment(appointment.getAppointmentId()));
    }

    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }
}