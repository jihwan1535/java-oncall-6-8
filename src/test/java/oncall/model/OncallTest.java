package oncall.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class OncallTest {

    @Test
    void 평일_근무자와_주말_근무자_정보가_다르면_예외가_발생() {
        // given
        Workers weekdayWorkers = Workers.fromWorkerNames(List.of("김일번", "김이번", "김삼번", "김사번", "김오번"));
        Workers holidayWorkers = Workers.fromWorkerNames(List.of("김삼번", "김사번", "김오번", "김일번", "김육번"));

        // when & then
        assertThatThrownBy(() -> new Oncall(weekdayWorkers, holidayWorkers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}