// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.{ Syntax, SyntaxJ }
import org.nlogo.nvm.{ Context, Reporter }

class _randompoisson extends Reporter {
  override def syntax =
    SyntaxJ.reporterSyntax(
      Array(Syntax.NumberType),
      Syntax.NumberType)
  override def report(context: Context): java.lang.Double =
    Double.box(report_1(context, argEvalDoubleValue(context, 0)))
  def report_1(context: Context, mean: Double): Double = {
    var q = 0
    var sum = -StrictMath.log(1 - context.job.random.nextDouble)
    while (sum <= mean) {
      q += 1
      sum -= StrictMath.log(1 - context.job.random.nextDouble)
    }
    q
  }
}
