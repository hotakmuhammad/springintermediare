package fr.dawan.springintermediare.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditingAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("John Doe");
    }
}
