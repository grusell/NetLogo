// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Command, Context }

class _set extends Command {
  override def syntax2 =
    Syntax.commandSyntax(List(Syntax.WildcardType,
                              Syntax.WildcardType))
  // we get compiled out of existence
  override def perform(context: Context) =
    throw new UnsupportedOperationException
}
