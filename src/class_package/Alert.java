package class_package;

import java.util.Objects;

/**
 * Created by Vlad on 28.09.2016.
 */
public class Alert implements /*Identifiable<Alert>, HasUniqueKey<Alert>,*/ CopyInterface<Alert> {
    private final long apamaInstanceId;
    private final Long id;

    private final long entryTime;
    private final String serviceId;
    private final long severity;
    private final String subject;
    private final String message;
    private final boolean closed;
    private final long closedTime;

    public Alert(final long apamaInstanceId, final long id, final long entryTime, final String serviceId,
                 final long severity, final String subject, final String message, final boolean closed, final long closedTime) {
        Objects.requireNonNull(id);
        this.apamaInstanceId = apamaInstanceId;
        this.id = id;
        this.entryTime = entryTime;
        this.serviceId = serviceId;
        this.severity = severity;
        this.subject = subject;
        this.message = message;
        this.closed = closed;
        this.closedTime = closedTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public long getSeverity() {
        return severity;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public boolean isClosed() {
        return closed;
    }

    public long getClosedTime() {
        return closedTime;
    }

    @Override
    public Alert copy() {
        return this;
    }
/*
    @Override
    public long getApamaInstanceId() {
        return apamaInstanceId;
    }*/

    public Long getId() {
        return id;
    }
/*
    @Override
    public UniqueKey getUniqueKey() {
        return createKey(id);
    }

    public static UniqueKey createKey(long id) {
        return new UniqueKey(id);
    }*/

    @Override
    public String toString() {
        return "[alert: " +
                " apamaInstanceId: " + apamaInstanceId +
                " id: " + id +
                " entryTime: " + entryTime +
                " serviceId: " + serviceId +
                " severity: " + severity +
                " subject: " + subject +
                " message: " + message +
                " closed: " + closed +
                " closedTime: " + closedTime +
                " ]";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Alert alert = (Alert) o;
        return apamaInstanceId == alert.apamaInstanceId
                && entryTime == alert.entryTime
                && severity == alert.severity
                && closed == alert.closed
                && closedTime == alert.closedTime
                && Objects.equals(id, alert.id)
                && Objects.equals(serviceId, alert.serviceId)
                && Objects.equals(subject, alert.subject)
                && Objects.equals(message, alert.message)
                ;
    }

    @Override
    public int hashCode() {
        return (int) (apamaInstanceId ^ (apamaInstanceId >>> 32));
    }
}
