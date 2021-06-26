// Generated from /mnt/c/users/agux/desktop/Archivos Adicionales/Universidad/9no Cuatrimestre/Tecnicas de Compilacion/tp1/src/main/java/tp1/programa.g4 by ANTLR 4.8

package tp1;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link programaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface programaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link programaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(programaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(programaParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(programaParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#puntocoma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPuntocoma(programaParser.PuntocomaContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(programaParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#verificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerificador(programaParser.VerificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(programaParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#tipo_de_datos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_de_datos(programaParser.Tipo_de_datosContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#asignacion_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion_simple(programaParser.Asignacion_simpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(programaParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#opal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpal(programaParser.OpalContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(programaParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(programaParser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(programaParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(programaParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(programaParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#logico_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogico_comp(programaParser.Logico_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#comparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(programaParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(programaParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#bloque_estructuras_de_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_estructuras_de_control(programaParser.Bloque_estructuras_de_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#pos_pre_incremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_pre_incremento(programaParser.Pos_pre_incrementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#bloque_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque_for(programaParser.Bloque_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#iwhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIwhile(programaParser.IwhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#iif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIif(programaParser.IifContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#ifor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfor(programaParser.IforContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#una_o_mas_variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUna_o_mas_variables(programaParser.Una_o_mas_variablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#tipo_de_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_de_funcion(programaParser.Tipo_de_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(programaParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#declaracion_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_funcion(programaParser.Declaracion_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#definicion_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion_funcion(programaParser.Definicion_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#param_declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_declaracion(programaParser.Param_declaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#param_definicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_definicion(programaParser.Param_definicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link programaParser#finalizar_con_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalizar_con_return(programaParser.Finalizar_con_returnContext ctx);
}