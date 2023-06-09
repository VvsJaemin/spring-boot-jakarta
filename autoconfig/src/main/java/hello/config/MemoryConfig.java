package hello.config;

import hello.memory.MemoryCondition;
import hello.memory.MemoryController;
import hello.memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Conditional(MemoryCondition.class) // true일경우에만 빈 등록 -> 아래 메서드 실행
@ConditionalOnProperty(name = "memory", havingValue = "on") //
public class MemoryConfig {

    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
