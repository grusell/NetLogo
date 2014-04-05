// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.{ Syntax, SyntaxJ }
import org.nlogo.nvm.{ Command, Context }

class _changetopology extends Command {
  override def syntax =
    SyntaxJ.commandSyntax(
      Array(Syntax.BooleanType, Syntax.BooleanType))
  override def perform(context: Context) {
    workspace.changeTopology(
      argEvalBooleanValue(context, 0),
      argEvalBooleanValue(context, 1))
    context.ip = next
  }
}
