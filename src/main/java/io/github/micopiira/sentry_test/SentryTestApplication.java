package io.github.micopiira.sentry_test;

import io.micrometer.observation.ObservationTextPublisher;
import io.sentry.Sentry;
import io.sentry.SentryOptions;
import io.sentry.opentelemetry.OtelSentryPropagator;
import io.sentry.opentelemetry.OtelSentrySpanProcessor;
import io.sentry.opentelemetry.OtelSpanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SentryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentryTestApplication.class, args);
	}

	@Bean
	Sentry.OptionsConfiguration<SentryOptions> optionsConfiguration() {
		return options -> options.setSpanFactory(new OtelSpanFactory());
	}

	@Bean
	OtelSentryPropagator otelSentryPropagator() {
		return new OtelSentryPropagator();
	}

	@Bean
	OtelSentrySpanProcessor otelSentrySpanProcessor() {
		return new OtelSentrySpanProcessor();
	}

	@Bean
	ObservationTextPublisher observationTextPublisher() {
		return new ObservationTextPublisher();
	}

}
