// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Context, Reporter, Pure, CustomGenerated }

class _or extends Reporter with Pure with CustomGenerated {
  override def syntax2 =
    Syntax.reporterSyntax(
      left = Syntax.BooleanType,
      right = List(Syntax.BooleanType),
      ret = Syntax.BooleanType,
      precedence = Syntax.NormalPrecedence - 6)
  override def report(context: Context): java.lang.Boolean =
    if (argEvalBooleanValue(context, 0))
      java.lang.Boolean.TRUE
    else
      argEvalBoolean(context, 1)
}
