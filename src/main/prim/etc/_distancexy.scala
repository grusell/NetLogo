// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Context, Reporter }

class _distancexy extends Reporter {

  override def syntax =
    Syntax.reporterSyntax(
      right = List(Syntax.NumberType, Syntax.NumberType),
      ret = Syntax.NumberType,
      agentClassString = "-TP-")

  override def report(context: Context): java.lang.Double =
    Double.box(
      report_1(context,
        argEvalDoubleValue(context, 0),
        argEvalDoubleValue(context, 1)))

  def report_1(context: Context, arg0: Double, arg1: Double): Double =
    world.protractor.distance(
      context.agent, arg0, arg1, true)

}
