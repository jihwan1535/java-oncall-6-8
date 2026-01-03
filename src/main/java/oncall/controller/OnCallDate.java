package oncall.controller;

import oncall.model.DayOfWeek;
import oncall.model.Month;

public record OnCallDate(Month month, DayOfWeek dayOfWeek) {
}
