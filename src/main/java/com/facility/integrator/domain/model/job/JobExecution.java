package com.facility.integrator.domain.model.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;

import static com.facility.integrator.domain.model.job.JobExecution.JobExecutionStatus.COMPLETED;
import static com.facility.integrator.domain.model.job.JobExecution.JobExecutionStatus.FAIL;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity(name = "job_execution")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class JobExecution implements Serializable {

    private static final long serialVersionUID = -7970966167677154669L;
    @Id
    @Column(name = "id_job_execution", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "file_name", nullable = false, length = 100)
    String fileName;

    @Column(name = "ind_status", nullable = false, length = 30)
    String status;

    @Column(name = "started_at", nullable = false)
    Instant startedAt;

    @Column(name = "updated_at", nullable = false)
    Instant updatedAt;

    @Builder
    public JobExecution(final String fileName, final JobExecutionStatus status) {
        this.id = 0;
        this.fileName = fileName;
        this.status = status.name();
        this.startedAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public JobExecution markAsFail() {
        return new JobExecution(this.id, this.fileName, FAIL.name(), this.startedAt, Instant.now());
    }

    public JobExecution markAsCompleted() {
        return new JobExecution(this.id, this.fileName, COMPLETED.name(), this.startedAt, Instant.now());
    }

    public enum JobExecutionStatus {
        PROCESSING,
        COMPLETED,
        FAIL;
    }
}
