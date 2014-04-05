// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.agent.Turtle
import org.nlogo.core.{ Syntax, SyntaxJ }
import org.nlogo.nvm.{ Command, Context }

class _facexynowrap extends Command {
  override def syntax =
    SyntaxJ.commandSyntax(
      Array(Syntax.NumberType, Syntax.NumberType),
      "-T--", true)
  override def perform(context: Context) {
    context.agent match {
      case turtle: Turtle =>
        turtle.face(
          argEvalDoubleValue(context, 0),
          argEvalDoubleValue(context, 1),
          false)
    }
    context.ip = next
  }
}
