// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.api.{ AgentException, Nobody }
import org.nlogo.nvm.{ Reporter, Context }

class _patch extends Reporter {

  override def syntax2 =
    Syntax.reporterSyntax(
      right = List(Syntax.NumberType, Syntax.NumberType),
      ret = Syntax.PatchType | Syntax.NobodyType)

  // I've tried to rejigger this and the result gets past TryCatchSafeChecker but then doesn't work
  // at runtime ("Inconsistent stack height") - ST 2/10/09
  override def report(context: Context): AnyRef =
    try world.getPatchAt(
      argEvalDoubleValue(context, 0),
      argEvalDoubleValue(context, 1))
    catch {
      case _: AgentException => Nobody
    }

}
