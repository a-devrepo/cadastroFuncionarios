package controllers;

import exceptions.DadosEntradaException;

public class InputValidator {

	public static void validarSalario(String valor) {
		try {
			
			Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			throw new DadosEntradaException("Valor inválido. O salário deve ser um número.");
		}
	}
}
